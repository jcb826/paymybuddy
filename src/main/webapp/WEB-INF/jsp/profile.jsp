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



        <!-- Bootstrap core CSS -->
        <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

        <style>
          .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
          }

          @media (min-width: 768px) {
            .bd-placeholder-img-lg {
              font-size: 3.5rem;
            }
          }
        </style>


        <!-- Custom styles for this template -->
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
              <a class="py-2 text-dark text-decoration-none" href="/paymybuddy/logout">Log off </a>
            </nav>
          </header>
          <div id="button-profile">

            <div class="selected"><a href="add-iban"><button class="btn btn-lg btn-primary btn-block">Add an IBAN</button></a></div>
            <div class="selected"><a href="transfer-to-bank"><button class="btn btn-lg btn-primary btn-block">Transfer cash to your bank</button></a></div>
            <div class="selected"><a href="transfer-to-account"><button class="btn btn-lg btn-primary btn-block">Add cash on your account</button></a></div>

          </div>

 <main>
                             </br>
                             <h2 class="display-6 text-left mb-4">My account balance</h2>

                             <div class="table-responsive">
                               <table class="table text-center">
                                 <thead>
                                   <tr>
                                     <th style="width: 50%;">User</th>
                                     <th style="width: 50%;">Amount</th>
                                   </tr>
                                 </thead>
                                 <tbody>

                                      <tr>
                                      <td> ${account.firstName} ${account.lastName}</td>
                                      <td>${account.account.amount}</td>
                                      </tr>

                                 </tbody>
                               </table>
                             </div>
                           </main>



      </body>


      </html>