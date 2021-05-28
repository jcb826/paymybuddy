<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

      <!doctype html>
      <html lang="en">

      <head>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.82.0">
        <title>Pricing example · Bootstrap v5.0</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/pricing/">
        <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="transfer-to-account.css" rel="stylesheet">

      </head>

      <body>

        <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
          <symbol id="check" viewBox="0 0 16 16">
            <title>Check</title>
            <path
              d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
          </symbol>
        </svg>

        <div class="container py-3">
          <header class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
            <div>
              <h4 class="logo">Pay My Budy</h4>
            </div>
            <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
              <a class="me-3 py-2 text-dark text-decoration-none" href="/paymybuddy">Home</a>
              <a class="me-3 py-2 text-dark text-decoration-none" href="/paymybuddy/transfer">Transfer</a>
              <a class="me-3 py-2 text-dark text-decoration-none" href="/paymybuddy/profile">Profile</a>
              <a class="me-3 py-2 text-dark text-decoration-none" href="/paymybuddy/contact">Contact</a>
              <a class="py-2 text-dark text-decoration-none" href="/paymybuddy/signin">Log off </a>
            </nav>
          </header>

         <div class="row">
           <div class="col-75">
             <div class="container">
               <form action="/action_page.php">

                 <div class="row">
                   <div class="col-50">
                     <h3>Billing Address</h3>
                     <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                     <input type="text" id="fname" name="firstname" placeholder="John M. Doe">
                     <label for="email"><i class="fa fa-envelope"></i> Email</label>
                     <input type="text" id="email" name="email" placeholder="john@example.com">
                     <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                     <input type="text" id="adr" name="address" placeholder="542 W. 15th Street">
                     <label for="city"><i class="fa fa-institution"></i> City</label>
                     <input type="text" id="city" name="city" placeholder="New York">

                     <div class="row">
                       <div class="col-50">
                         <label for="state">State</label>
                         <input type="text" id="state" name="state" placeholder="NY">
                       </div>
                       <div class="col-50">
                         <label for="zip">Zip</label>
                         <input type="text" id="zip" name="zip" placeholder="10001">
                       </div>
                     </div>
                   </div>

                   <div class="col-50">
                     <h3>Payment</h3>
                     <label for="fname">Accepted Cards</label>
                     <div class="icon-container">
                       <i class="fa fa-cc-visa" style="color:navy;"></i>
                       <i class="fa fa-cc-amex" style="color:blue;"></i>
                       <i class="fa fa-cc-mastercard" style="color:red;"></i>
                       <i class="fa fa-cc-discover" style="color:orange;"></i>
                     </div>
                     <label for="cname">Name on Card</label>
                     <input type="text" id="cname" name="cardname" placeholder="John More Doe">
                     <label for="ccnum">Credit card number</label>
                     <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
                     <label for="expmonth">Exp Month</label>
                     <input type="text" id="expmonth" name="expmonth" placeholder="September">

                     <div class="row">
                       <div class="col-50">
                         <label for="expyear">Exp Year</label>
                         <input type="text" id="expyear" name="expyear" placeholder="2018">
                       </div>
                       <div class="col-50">
                         <label for="cvv">CVV</label>
                         <input type="text" id="cvv" name="cvv" placeholder="352">
                       </div>
                     </div>
                   </div>

                 </div>
                 <label>
                   <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
                 </label>
                 <input type="submit" value="Continue to checkout" class="btn">
               </form>
             </div>
           </div>

           <div class="col-25">

           </div>
         </div>

              <footer class="pt-4 my-md-5 pt-md-5 border-top">

              </footer>
            </div>
          </div>
        </div>

      </body>


      </html>