CREATE TABLE users (
    id SERIAL PRIMARY KEY,  -- Auto-incremented primary key
    username VARCHAR(50) NOT NULL UNIQUE,  -- Unique username for the user
    email VARCHAR(100) NOT NULL UNIQUE,  -- Unique email address
    password_hash TEXT NOT NULL,  -- Hashed password
    first_name VARCHAR(50) NOT NULL,  -- User's first name
    last_name VARCHAR(50) NOT NULL,  -- User's last name
    phone_number VARCHAR(15),  -- Optional phone number, validated in application
    role VARCHAR(20) NOT NULL CHECK (role IN ('JOB_SEEKER', 'EMPLOYER', 'ADMIN')), -- User role
    profile_picture_url TEXT,  -- Optional profile picture URL
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Automatically set creation time
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Automatically set update time
    last_login_at TIMESTAMP,  -- Track user's last login time
    is_active BOOLEAN DEFAULT TRUE,  -- Indicates if the account is active
    is_verified BOOLEAN DEFAULT FALSE  -- Indicates if the email is verified
);

-- Indexes to optimize searches
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_role ON users(role);


CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_updated_at
BEFORE UPDATE ON users
FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();
