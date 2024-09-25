### Test Case Design for Checkout Process on SquareArt

#### 1. **Test Case: Add Product to Cart (After Login)**

- **Precondition**: User is logged in.
- **Steps**:
  1.  Navigate to product listing.
  2.  Select a product.
  3.  Click "Add to Cart".
  4.  View the cart dropdown.
- **Expected Outcome**:
  - Product is successfully added to cart.
  - Cart dropdown shows the product immediately.
- **Acceptance Criteria**: Product is visible in the cart dropdown after login.

#### 2. **Test Case: Attempt to Add Product to Cart Without Login**

- **Precondition**: User is not logged in.
- **Steps**:
  1.  Navigate to a product page.
  2.  Try adding the product to the cart.
- **Expected Outcome**:
  - User is redirected to the login page or shown a login prompt.
- **Acceptance Criteria**: User must log in to add products to the cart.

#### 3. **Test Case: Checkout Page Validation for Correct Cart Details**

- **Precondition**: User has products in the cart.
- **Steps**:
  1.  Go to the cart page.
  2.  Proceed to the checkout page.
  3.  Validate that the product details (quantity, price, amount) are correct.
- **Expected Outcome**:
  - Product details are accurately displayed on the checkout page.
- **Acceptance Criteria**: The cart and checkout page show the same product details.

#### 4. **Test Case: Increase Product Quantity from Cart Dropdown**

- **Precondition**: User has at least one product in the cart.
- **Steps**:
  1.  Open the cart dropdown.
  2.  Increase the product quantity.
- **Expected Outcome**:
  - Product quantity increases.
  - The total in the dropdown reflects the new quantity and price.
- **Acceptance Criteria**: Quantity and total adjust correctly in the cart dropdown.

#### 5. **Test Case: Decrease Product Quantity from Cart Dropdown**

- **Precondition**: User has at least two units of a product in the cart.
- **Steps**:
  1.  Open the cart dropdown.
  2.  Decrease the product quantity.
- **Expected Outcome**:
  - Product quantity decreases.
  - The total adjusts accordingly.
- **Acceptance Criteria**: Quantity and total adjust correctly in the cart dropdown.

#### 6. **Test Case: Navigate to Cart Page**

- **Steps**:
  1.  Click the cart icon.
  2.  Go to the cart page.
- **Expected Outcome**:
  - Cart page is displayed with all products and their details.
- **Acceptance Criteria**: Cart page is accessible and displays correct product information.

#### 7. **Test Case: Remove Product from Cart (Individually)**

- **Precondition**: User has multiple products in the cart.
- **Steps**:
  1.  Go to the cart page.
  2.  Remove a product.
- **Expected Outcome**:
  - Product is removed.
  - The total reflects the removal.
- **Acceptance Criteria**: Product removal is immediate, and total updates accordingly.

#### 8. **Test Case: Remove All Products from Cart**

- **Precondition**: User has multiple products in the cart.
- **Steps**:
  1.  Select all products.
  2.  Click "Remove All".
- **Expected Outcome**:
  - All products are removed.
  - Cart is empty.
- **Acceptance Criteria**: Cart should be completely empty after "Remove All".

#### 9. **Test Case: Select Shipping Option**

- **Precondition**: User is on the checkout page.
- **Steps**:
  1.  Select between "Shipping Delivery" and "Pickup".
- **Expected Outcome**:
  - User can choose a delivery method.
  - Appropriate fields appear based on the choice.
- **Acceptance Criteria**: Shipping option correctly modifies the form.

#### 10. **Test Case: Shipping Delivery (Address Required)**

- **Precondition**: User selects "Shipping Delivery".
- **Steps**:
  1.  Choose "Shipping Delivery".
  2.  Add a new address or select the default one.
- **Expected Outcome**:
  - User can add an address if no default exists.
  - The system auto-selects the default address if available.
- **Acceptance Criteria**: Correct address selection behavior for shipping.

#### 11. **Test Case: Pickup Option (Address Auto-filled)**

- **Precondition**: User selects "Pickup".
- **Steps**:
  1.  Select "Pickup".
- **Expected Outcome**:
  - Store address is displayed.
  - No shipping fee is added.
- **Acceptance Criteria**: Store address is set automatically, and no shipping fee is calculated.

#### 12. **Test Case: Submit Checkout**

- **Precondition**: User fills in all checkout details.
- **Steps**:
  1.  Complete the checkout form.
  2.  Click "Submit" to proceed to payment.
- **Expected Outcome**:
  - Checkout form submits, and user is redirected to payment.
- **Acceptance Criteria**: Form is submitted, and user proceeds to the payment gateway.

#### 13. **Test Case: Invalid Checkout Input (Empty Fields)**

- **Precondition**: User is on the checkout page.
- **Steps**:
  1.  Leave required fields empty (e.g., address, payment method).
  2.  Try to submit the checkout.
- **Expected Outcome**:
  - Error messages for missing input appear.
- **Acceptance Criteria**: Error messages prevent submission.

#### 14. **Test Case: Checkout with Extreme Quantity Values**

- **Precondition**: User is on the checkout page.
- **Steps**:
  1.  Set an extreme value for product quantity (e.g., 0 or maximum allowed).
  2.  Proceed to checkout.
- **Expected Outcome**:
  - Proper validation of minimum and maximum values.
- **Acceptance Criteria**: Quantity validation should prevent incorrect inputs.

### Acceptance Criteria Summary:

- **Valid Inputs**: All expected actions (adding/removing products, form completion) work as expected.
- **Invalid Inputs**: Error messages prevent improper submission.
- **Edge Cases**: Handling of extreme quantities, empty fields, and proper validation.
