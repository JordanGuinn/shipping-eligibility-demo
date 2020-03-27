# Shipping Eligibility Project Demo

## Introduction

Welcome to my quick demo of the shipping eligibility project!  This application operates as a proof-of-concept Spring Boot application for determining the eligibility of a given item for a new shipping service being rolled out.  Enjoy!

## Prerequisites
The setup here is pretty OS-agnostic - it involves the use of two separate docker containers: one for the MySQL database used by the Spring Boot application, and one for the Spring Boot application itself (bundled up into a single JAR file).  They can interact with each other directly from container to container, so there's no need for additional gathering of dependencies on your end.

- You're going to need to have [Docker](https://www.docker.com/get-started) installed on your local machine.
- That's it!

## Getting Started

### Installation
Installation and subsequent spin-up of this program is pretty straightforward.

 - Install [Docker](https://www.docker.com/get-started), if you haven't already.
 - Clone this entire repository, or download the ZIP itself to your machine.
 - Once downloaded, simply run `./start.sh` from the root of the project.
 - Congratulations!  The shipping-eligibility API is now up and running, listening on port 3314 on your local machine.
 
 If you should experience any downtime or crashes for whatever reason, simply run `./restart.sh` to get everything back to fully functional again.

### API Details
There are 5 APIs total available within this Spring Boot application - one indicates to the end user whether or not a given item is eligible for our new shipping program, and the others allow for various administrative configurations around the guidelines of said program.  The details are as follows:

#### GET /item/isValid
- **Description**: Indicate whether or not a listing item is eligible for the new shipping program.
- **Query Parameters**:
    - `title` (required)
    - `seller` (required)
    - `category` (required)
    - `price` (required)

#### POST /admin/categoryApproval
- **Description**: Specify categories (both existing and brand new) that should be made eligible for the new shipping program.
- **Query Parameters**:
    - `category` (required)

#### DELETE /admin/categoryApproval
- **Description**: Specify categories (both existing and brand new) that should be removed from eligibility for the new shipping program.
- **Query Parameters**:
    - `category` (required)

#### POST /admin/userEnrollment
- **Description**: Specify sellers (both existing and brand new) that should be removed from eligibility for the new shipping program.
- **Query Parameters**:
    - `name` (required)

#### DELETE /admin/userEnrollment
- **Description**: Specify sellers (both existing and brand new) that should be removed from eligibility for the new shipping program.
- **Query Parameters**:
    - `name` (required)

### Usage
Instantiation and bootstrapping of this Spring Boot application inherently includes a number of seeders, so that there's some play data to work with starting out.  However, the administrative APIs captured above should allow for easy addition/removal from of the data set available.
Here are a couple examples you might consider trying out:

- Check the eligibility of a given item for a given seller.
```
curl "localhost:3314/item/isValid?title=Television&seller=david&category=1&price=100"
```

- Enroll a new seller into the shipping eligibility program.
```
curl -X POST "localhost:3314/admin/userEnrollment?name=james"
```

- Check the eligibility of a given item with that same seller.
```
curl "localhost:3314/item/isValid?title=Television&seller=james&category=1&price=100"
```

- Remove a category from eligibility with the shipping program.
```
curl -X DELETE "localhost:3314/admin/categoryApproval?category=1"
```

- Check the eligibility of that same item with the updated category.
```
curl "localhost:3314/item/isValid?title=Television&seller=james&category=1&price=100"
```

## Feedback
As with any API, there's always room for improvement and expansion.  If there's anything you'd like to see in here, do let me know and I'll see what I can do.  Thanks for taking the time to check this out!
