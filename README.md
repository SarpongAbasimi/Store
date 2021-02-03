# Building an online app which sells only one product.

# Tech Stack

- Scala Play
- Anorm
- Cats
- Postgresql

# How to run application
- `cd` into the application root directory
- Type `sbt run`

# How to run unit tests
-  `sbt test`

# An example of an order.

```
Order status CREATED
Order ID: 5VT418307P474322J
```

``` self => GET:https://api.sandbox.paypal.com/v2/checkout/orders/5VT418307P474322J
approve => GET:https://www.sandbox.paypal.com/checkoutnow?token=5VT418307P474322J
update => PATCH:https://api.sandbox.paypal.com/v2/checkout/orders/5VT418307P474322J
capture => POST:https://api.sandbox.paypal.com/v2/checkout/orders/5VT418307P474322J/capture
```
