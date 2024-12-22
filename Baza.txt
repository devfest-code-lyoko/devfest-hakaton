CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for each user
    firstname VARCHAR(50) NOT NULL,   -- First name of the user
    lastname VARCHAR(50) NOT NULL,     -- Surname of the user
    password VARCHAR(255) NOT NULL,  -- Password (consider hashing this)
    username VARCHAR(50) UNIQUE NOT NULL, -- Username (must be unique)
    type VARCHAR(50) NOT NULL, -- Type of user
    address VARCHAR(50) NOT NULL,                    -- Address of the user
    subscription VARCHAR(50), -- Subscription status
    mail VARCHAR(100) UNIQUE NOT NULL -- Email (must be unique)
);

CREATE TABLE services (
    id INT AUTO_INCREMENT PRIMARY KEY,
    senior_username VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    address VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    helper_username VARCHAR(255)
);

INSERT INTO users (firstname, lastname, password, username, type, address, subscription, mail) 
VALUES
('John', 'Doe', '123', 'john_doe', 'senior', '123 Main St', 'monthly', 'john.doe@gmail.com'),
('Jane', 'Smith', '123', 'jane_smith', 'senior', '456 Elm St', 'yearly', 'jane.smith@gmail.com'),
('Alice', 'Johnson', '123', 'alicej', 'helper', '789 Oak St', NULL, 'alice.johnson@gmail.com'),
('Bob', 'Brown', '123', 'bobbrown', 'helper', '101 Maple St', NULL, 'bob.brown@gmail.com'),
('Peter', 'Parker', '123', 'peter_parker', 'senior', '789 Maple Ave, Metropolis', 'monthly', 'peter.parker@gmail.com'),
('Clark', 'Kent', '123', 'clark_kent', 'senior', '101 Broadway, Gotham City', 'yearly', 'clark.kent@gmail.com'),
('Diana', 'Prince', '123', 'diana_prince', 'senior', '202 Wonder Lane, Amazonia', 'yearly', 'diana.prince@gmail.com'),
('Garry', 'Potter', '123', 'garry_potter', 'senior', '30 Parkfield', 'monthly', 'garry.potter@gmail.com'),
('Bob', 'White', '123', 'bob_white', 'senior', '782 Orchard Drive Sunnyvale, CA 94087', 'monthly', 'bob.white@gmail.com'),
('Charlie', 'Richardson', '123', 'charlie_richardson', 'senior', '1456 Maple Avenue Springfield, IL 62704', 'yearly',
'charlie.richardson@gmail.com'),
('Amanda', 'Collins', '123', 'amanda_collins', 'senior', '411 Cedar Lane Portland, OR 97209', 'yearly', 'amanda.collins@gmail.com');


INSERT INTO services (senior_username, name, description, address, price)
VALUES
    ('john_doe', 'Housekeeping', 'Gardening service, including mowing and trimming.', '123 Greenway Blvd, Springfield', 50),
    ('jane_smith', 'Housekeeping', 'Home cleaning and organization.', '456 Elm St, Shelbyville', 70),
    ('peter_parker', 'Housekeeping', 'Making breakfast and lunch.', '789 Maple Ave, Metropolis', 60),
    ('clark_kent', 'Handyman Services', 'Plumbing and furniture assembling.', '101 Broadway, Gotham City', 100),
    ('diana_prince', 'Groceries shopping', 'Shopping for bread, milk, butter and chicken.', '202 Wonder Lane, Amazonia', 120),
    ('garry_potter', 'Medicine delivery', 'Atorvastatin, Metformin, Levothyroxine.', '30 Parkfield', 90),
    ('bob_white', 'Taxi service', 'Going to a doctor.', '782 Orchard Drive Sunnyvale, CA 94087', 50),
    ('charlie_richardson', 'Taxi service', 'Going to a hairdresser.', '1456 Maple Avenue Springfield, IL 62704', 10),
    ('amanda_collins', 'Animal care', 'Husky, 30 minutes walk in a park.', '411 Cedar Lane Portland, OR 97209', 70);
