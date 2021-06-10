<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

      <!doctype html>
      <html lang="en">

      <head>


        <title>transfer to account</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/pricing/">
        <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="index.css" rel="stylesheet">

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

       <div id="content">
           <div class="card-top border-bottom text-center">  <span id="logo">Transfer cash to your Pay my buddy account</span> </div>
           <div class="card-body">
               <div class="row upper">  </div>
               <div class="row">
                   <div class="col-md-7">
                       <div class="left border">
                           <div class="row"> <span class="header">Payment</span>
                               <div class="icons"> <img src="https://img.icons8.com/color/48/000000/visa.png" /> <img src="https://img.icons8.com/color/48/000000/mastercard-logo.png" /> <img src="https://img.icons8.com/color/48/000000/maestro.png" /> </div>
                           </div>
                           <form> <span>Cardholder's name:</span> <input placeholder="Linda Williams"> <span>Card Number:</span> <input placeholder="0125 6780 4567 9909">
                               <div class="row">
                                   <div class="col-4"><span>Expiry date:</span> <input placeholder="YY/MM"> </div>
                                   <div class="col-4"><span>CVV:</span> <input id="cvv"> </div>
                               </div> <input type="checkbox" id="save_card" class="align-left"> <label for="save_card">Save card details to wallet</label>
                           </form>
                       </div>
                   </div>
                   <div class="col-md-5">
                       <div class="right border">
                           <div class="header">Enter an amount</div>

                           <div class="row item">
                               <div class="col-4 align-self-center"></div>



 <form:form action="transfer-to-account" method="post" class="needs-validation" modelAttribute="transferToAccountForm">
                            <div class="row g-3">


                              <div class="col-8">
                                <label for="amount" class="form-label"></label>
                                <form:input path="amount" type="number" step="0.01" class="form-control floatingInput" />
                                <div class="invalid-feedback">
                                  Please provide a valid amount.
                                </div>
                              </div>

                              <div class="col-md-3">
                                </br>


                              </div>
                            </div>



                           </div>



                           </div><form:button id="btn-credit-card" type="submit">Place order</form:button>


                       </div>
                       </form:form>
                   </div>
               </div>
           </div>
           <div> </div>
       </div>

      </body>


      </html>