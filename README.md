Shoping App Using Sprin Boot 

Developed using Spring Boot and MySQL, this shopping app facilitates various functionalities. 

It employs Intellij for development and Postman for API testing. 

Core tables include 'order' with details like order ID, product ID, amount, quantity, date, and coupon, 'product' tracking product details and inventory, 'coupon' storing discount information, and 'payment' for transaction details. 

APIs enable adding products, retrieving inventory, adding coupons, listing all coupons, placing orders, fetching all orders, retrieving orders by order ID, and making payments. 

This ecosystem streamlines e-commerce operations efficiently.


To set up a new MySQL database named "shopping," follow these steps:

1. Open IntelliJ IDEA and open your project.
2. Navigate to the folder named "Demo."
3. Locate the following path: `demo > src > main > resources > application.properties`.
4. In the `application.properties` file, find the property `spring.datasource.url` and set it to `jdbc:mysql://localhost:3306/shopping`.
5. Save the changes.

To run the application:

1. Find the file named `ShopingApplication.java`.
2. It should be located at `demo > src > main > java > com.example.demo > ShopingApplication`.
3. Right-click on `ShopingApplication.java` and select "Run" to start the application.

Ensure that your MySQL server is running on `localhost` and listening on port `3306`. This setup will connect your Spring Boot application to the MySQL database named "shopping."

To follow the given APIs in Postman, perform the following steps:

1. **Add a new product:**
   Send a POST request to `http://localhost:8080/addProduct` with the required product details in the request body.

2. **Add an order by product ID:**
   Send a POST request to `http://localhost:8080/addOrder` with query parameters `productId`, `quantity`, and `coupen`. 
   For example, `http://localhost:8080/addOrder?productId=1&quantity=5&coupen=OFF5`.

3. **Add a new coupon:**
   Send a POST request to `http://localhost:8080/addCoupen`.

4. **Fetch all coupons:**
   Send a GET request to `http://localhost:8080/fetchCoupen`.

5. **Print product inventory:**
   Send a GET request to `http://localhost:8080/inventory`.

6. **Print all orders:**
   Send a GET request to `http://localhost:8080/allOrders`.

7. **Fetch order details by order ID:**
   Send a GET request to `http://localhost:8080/orders/{orderId}`, replacing `{orderId}` with the actual order ID. 
   For example, `http://localhost:8080/orders/123`.

8. **Make payment for an order:**
   Send a POST request to `http://localhost:8080/payment/{orderId}`, replacing `{orderId}` with the actual order ID. 
   For example, `http://localhost:8080/payment/1`.

Ensure that your Spring Boot application is running on `localhost` at port `8080` while testing these APIs in Postman. Adjust the request parameters and method types accordingly for each endpoint.
