CREATE TABLE accounts (
    account_id UUID PRIMARY KEY,

    account_number VARCHAR(20) NOT NULL UNIQUE,

    owner_id UUID NOT NULL,

    balance NUMERIC(14,2) NOT NULL DEFAULT 0.00,

    status account_status NOT NULL DEFAULT 'ACTIVE',

    account_type account_type NOT NULL,

    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    CONSTRAINT fk_accounts_owner
        FOREIGN KEY (owner_id)
        REFERENCES users(id),

    CONSTRAINT chk_balance_non_negative
        CHECK (balance >= 0)
);

CREATE INDEX idx_accounts_owner_id
ON accounts(owner_id);

