CREATE TABLE transactions (
    transaction_id UUID PRIMARY KEY,

    transaction_type transaction_type NOT NULL,

    amount NUMERIC(14,2) NOT NULL
        CHECK (amount > 0),

    from_account_id UUID,
    to_account_id UUID,

    status transaction_status NOT NULL,

    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    CONSTRAINT fk_tx_from_account
        FOREIGN KEY (from_account_id)
        REFERENCES accounts(account_id),

    CONSTRAINT fk_tx_to_account
        FOREIGN KEY (to_account_id)
        REFERENCES accounts(account_id),

    CONSTRAINT chk_tx_accounts
        CHECK (
            from_account_id IS NOT NULL
            OR to_account_id IS NOT NULL
        ),

    CONSTRAINT chk_tx_not_same_account
        CHECK (
            from_account_id IS NULL
            OR to_account_id IS NULL
            OR from_account_id <> to_account_id
        )
);

CREATE INDEX idx_tx_from_account
ON transactions(from_account_id);

CREATE INDEX idx_tx_to_account
ON transactions(to_account_id);

CREATE INDEX idx_tx_created_at
ON transactions(created_at);
-- enums
CREATE TYPE account_status AS ENUM ('ACTIVE','FROZEN','CLOSED');
CREATE TYPE account_type AS ENUM ('SAVINGS','CURRENT');
CREATE TYPE user_role AS ENUM ('USER','ADMIN');
CREATE TYPE transaction_type AS ENUM ('DEPOSIT','WITHDRAW','TRANSFER');
CREATE TYPE transaction_status AS ENUM ('SUCCESS','FAILED');

-- users table
CREATE TABLE users (
    id UUID PRIMARY KEY,
    full_name TEXT NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone_number VARCHAR(15) NOT NULL UNIQUE,
    address TEXT,
    password_hash VARCHAR(255) NOT NULL,
    role user_role NOT NULL DEFAULT 'USER',
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

-- accounts table
CREATE TABLE accounts (
    account_id UUID PRIMARY KEY,
    account_number VARCHAR(20) UNIQUE NOT NULL,
    owner_id UUID NOT NULL REFERENCES users(id),
    balance NUMERIC(14,2) NOT NULL DEFAULT 0.00 CHECK (balance >= 0),
    status account_status NOT NULL DEFAULT 'ACTIVE',
    account_type account_type NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_accounts_owner_id ON accounts(owner_id);

-- transactions table
CREATE TABLE transactions (
    transaction_id UUID PRIMARY KEY,
    transaction_type transaction_type NOT NULL,
    amount NUMERIC(14,2) NOT NULL CHECK (amount > 0),
    from_account_id UUID REFERENCES accounts(account_id),
    to_account_id UUID REFERENCES accounts(account_id),
    status transaction_status NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    CHECK (from_account_id IS NOT NULL OR to_account_id IS NOT NULL),
    CHECK (from_account_id IS NULL OR to_account_id IS NULL OR from_account_id <> to_account_id)
);

CREATE INDEX idx_tx_from_account ON transactions(from_account_id);
CREATE INDEX idx_tx_to_account ON transactions(to_account_id);
CREATE INDEX idx_tx_created_at ON transactions(created_at);

