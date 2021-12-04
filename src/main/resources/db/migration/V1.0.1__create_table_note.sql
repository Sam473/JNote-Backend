CREATE TABLE NOTE (
    id INT PRIMARY KEY,
    title VARCHAR (50) NOT NULL,
    body VARCHAR (5000) NOT NULL,
    dateCreated DATETIME,
    dateLastModified DATETIME
);