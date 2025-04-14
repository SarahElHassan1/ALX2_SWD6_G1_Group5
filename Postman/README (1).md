
# Simple Books API - Full Test Suite

This Postman collection provides a complete test suite for the [Simple Books API](https://simple-books-api.glitch.me). It includes both **happy path scenarios** and **negative test cases** for validating core API functionalities such as authentication, book retrieval, order creation, and error handling.

## Base URL
```
https://simple-books-api.glitch.me
```

## Collection Overview

### 1. End-to-End Scenario (Happy Path)

- **GET** `/status` – Check if API is running.
- **POST** `/api-clients` – Register a client and retrieve an access token.
- **GET** `/books` – Retrieve all available books.
- **GET** `/books/1` – Get details for a specific book.
- **POST** `/orders` – Create a new order (authentication required).
- **GET** `/orders` – View all orders for the client.
- **GET** `/orders/{orderId}` – Get a specific order.
- **PATCH** `/orders/{orderId}` – Update an existing order.
- **DELETE** `/orders/{orderId}` – Cancel an order.

### 2. Error Handling (Negative Tests)

- Invalid token usage.
- Missing required fields (e.g., book ID).
- Out-of-stock or invalid book order.
- Register with a duplicate email.
- Access non-existent order.
- Unauthorized delete request.

## Environment Variables

| Variable      | Description                  |
|---------------|------------------------------|
| `baseUrl`     | API base URL                 |
| `accessToken` | Retrieved after registration |
| `orderId`     | Order ID created dynamically |

## How to Use

1. Import the collection into Postman.
2. Set up environment with `baseUrl` and leave other variables empty.
3. Run requests in order for full end-to-end flow.
4. Review tests and responses in the console/logs.

## Author
Created by Zainab Osama for API automation practice and testing purposes.
