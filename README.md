# Customer Payment System

This repository contains the implementation of a **Customer Payment System**, designed to handle and manage various types of payments (Cash, Check, and CreditCard). The system supports operations such as calculating payments, verifying authorization for specific payment types, and managing customer payment details.

## Features

1. **CustomerPayment Class**:
   - Implements `Comparable` to allow sorting based on the calculated payment value.
   - Includes common attributes such as `customerName`, `customerId`, and `amount`.

2. **Payment Types**:
   - **Cash**:
     - Payment = `amount - (discountRate / 100 * amount)`.
   - **Check**:
     - Payment = `amount`.
     - Includes `type` (CASHIER=1, CERTIFIED=2, PERSONAL=3).
     - Authorization:
       - Authorized if the type is CASHIER or if `amount <= accountBalance`.
       - Deducts amount from `accountBalance` for CERTIFIED and PERSONAL checks when authorized.
   - **CreditCard**:
     - Payment = `amount + chargingFee`.
     - Authorization:
       - Authorized if `expiryDate <= current date`.

3. **Interface: Payable**:
   - Defines the method `isAuthorized()` for payment verification.
   - Implemented by `Check` and `CreditCard` classes.

4. **Sorting**:
   - Payments are sorted in descending order of their calculated payment using `Collections.sort()`.

5. **Driver**:
   - Creates an `ArrayList` of type `CustomerPayment` and adds authorized payments to it.
   - Displays all payments using `printPaymentInfo()`.

## Classes and Methods

### `CustomerPayment`
- Common attributes: `customerName`, `customerId`, `amount`.
- Implements:
  - `Comparable<CustomerPayment>`: Compare based on calculated payment.
  - `toString()`, setters, getters, no-arg constructor, and all-field constructor.

### `Cash`
- Additional attribute: `discountRate`.
- Overrides:
  - `calculatePayment()`.
  - `toString()`.

### `Check`
- Additional attributes: `accountNumber`, `accountBalance`, `type`.
- Constants: `CASHIER=1`, `CERTIFIED=2`, `PERSONAL=3`.
- Overrides:
  - `calculatePayment()`.
  - `toString()`.
  - Implements `isAuthorized()` from `Payable`.

### `CreditCard`
- Additional attributes: `chargingFee`, `expiryDate`.
- Overrides:
  - `calculatePayment()`.
  - `toString()`.
  - Implements `isAuthorized()` from `Payable`.

### `Payable`
- Defines the method `isAuthorized()`.

### `Driver`
- Manages an `ArrayList` of `CustomerPayment`.
- Ensures payments are authorized before adding to the list.
- Sorts the list in descending order of calculated payments.
- Prints all payments using `printPaymentInfo()`.

---
