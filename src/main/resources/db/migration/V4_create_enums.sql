-- Account related enums
CREATE TYPE account_status AS ENUM (
    'ACTIVE',
    'FROZEN',
    'CLOSED'
);

CREATE TYPE account_type AS ENUM (
    'SAVINGS',
    'CURRENT'
);

-- User roles
CREATE TYPE user_role AS ENUM (
    'USER',
    'ADMIN'
);

-- Transaction types
CREATE TYPE transaction_type AS ENUM (
    'DEPOSIT',
    'WITHDRAW',
    'TRANSFER'
);

-- Transaction status
CREATE TYPE transaction_status AS ENUM (
    'SUCCESS',
    'FAILED'
);

