CREATE DATABASE student_event_hub;

USE student_event_hub;

-- ZipCodes Table
CREATE TABLE ZipCodes (
    zip_code_id VARCHAR(255) PRIMARY KEY,
    zip_code VARCHAR(10),
    city VARCHAR(255),
    State VARCHAR(255)
);

-- Users Table
CREATE TABLE Users (
    user_id VARCHAR(255) PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    age VARCHAR(10),
    university VARCHAR(255),
    university_id VARCHAR(255),
    zip_code VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

-- Events Table
CREATE TABLE Events (
    event_id VARCHAR(255) PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL,
    event_name VARCHAR(255) NOT NULL,
    event_details TEXT,
    event_date DATE,
    location VARCHAR(255),
    zip_code VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Hosts Table (Host-Event Relationship)
CREATE TABLE Hosts (
    user_id VARCHAR(255),
    event_id VARCHAR(255),
    PRIMARY KEY (user_id, event_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Attendees Table (Attendee-Event Relationship)
CREATE TABLE Attendees (
    user_id VARCHAR(255),
    event_id VARCHAR(255),
    registration_status VARCHAR(20) CHECK (registration_status IN ('Accepted', 'Declined', 'Pending')),
    attendee_rating INT,
    PRIMARY KEY (user_id, event_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Groups Table
CREATE TABLE EventGroups (
    group_id VARCHAR(255) PRIMARY KEY,
    admin_user_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (admin_user_id) REFERENCES Users(user_id)
);

-- GroupMembers Table (Group-Member Relationship)
CREATE TABLE GroupMembers (
    group_id VARCHAR(255),
    user_id VARCHAR(255),
    PRIMARY KEY (group_id, user_id),
    FOREIGN KEY (group_id) REFERENCES EventGroups(group_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Ratings Table (Event Ratings and Host Ratings)
CREATE TABLE Ratings (
    rating_id VARCHAR(255) PRIMARY KEY,
    rated_user_id VARCHAR(255),
    rating_by_user_id VARCHAR(255),
    rating_value INT CHECK (rating_value >= 1 AND rating_value <= 5),
    rating_date DATE,
    rating_for VARCHAR(255),
    FOREIGN KEY (rated_user_id) REFERENCES Users(user_id),
    FOREIGN KEY (rating_by_user_id) REFERENCES Users(user_id)
);

-- EventRegistrations Table (Attendee Registration Confirmation)
CREATE TABLE EventRegistrations (
    registration_id VARCHAR(255) PRIMARY KEY,
    event_id VARCHAR(255),
    user_id VARCHAR(255),
    registration_status VARCHAR(20) CHECK (registration_status IN ('Accepted', 'Declined')),
    confirmation_email_sent BOOLEAN,
    FOREIGN KEY (event_id) REFERENCES Events(event_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);