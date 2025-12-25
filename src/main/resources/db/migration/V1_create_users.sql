CREATE TABLE users (
    id UUID PRIMARY KEY,

    full_name TEXT NOT NULL,

    email VARCHAR(150) NOT NULL UNIQUE,

    phone_number VARCHAR(15) NOT NULL UNIQUE,

    address TEXT,

    password_hash VARCHAR(255) NOT NULL,

    role user_role NOT NULL DEFAULT 'USER',

    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    updated_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

