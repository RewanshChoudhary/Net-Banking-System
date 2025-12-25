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

