-- customers table
CREATE TABLE IF NOT EXISTS customers (
    id SERIAL PRIMARY KEY,
    "lead" TEXT DEFAULT 'YES',
    customer_name TEXT NOT NULL,
    customer_telephone TEXT NOT NULL,
    customer_email TEXT,
    customer_address TEXT
);

-- activities table
CREATE TABLE IF NOT EXISTS activities (
    id SERIAL PRIMARY KEY,
    "lead" TEXT DEFAULT 'YES',  
    activity TEXT NOT NULL
);

-- Insert default activities
INSERT INTO activities (activity)
VALUES 
('Phone Call'),
('Meeting'),
('Task'),
('Note')
ON CONFLICT DO NOTHING;  -- In case you run it again

-- customer_activities table
CREATE TABLE IF NOT EXISTS customer_activities (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    activity_id INTEGER NOT NULL,
    activity_date TIMESTAMP NOT NULL,
    activity_notes TEXT,
    FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE,
    FOREIGN KEY (activity_id) REFERENCES activities(id) ON DELETE CASCADE
);