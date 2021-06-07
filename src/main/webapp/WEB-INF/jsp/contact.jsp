<!doctype html>
<html lang="en">

<head>
  <%@ page pageEncoding="UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.82.0">
    <title>Pricing example · Bootstrap v5.0</title>
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
        <a class="py-2 text-dark text-decoration-none" href="/paymybuddy/logout">Log off </a>
      </nav>
    </header>
    <main>
      <section>
        <div>
          <div class="row">
            <div class="col-sm-12">
              <div class="row">
                <div class="col-sm-8 col-sm-offset-2">
                  <div>
                    <h2>CONTACT US</h2>
                  </div>
                  <form method="post" data-form-title="CONTACT US">
                    <input type="hidden" data-form-email="true">
                    <div class="form-group">
                      <input type="text" class="form-control" name="name" required="" placeholder="Name*"
                        data-form-field="Name">
                    </div>
                    <div class="form-group">
                      <input type="email" class="form-control" name="email" required="" placeholder="Email*"
                        data-form-field="Email">
                    </div>
                    <div class="form-group">
                      <input type="tel" class="form-control" name="phone" placeholder="Phone" data-form-field="Phone">
                    </div>
                    <div class="form-group">
                      <textarea class="form-control" name="message" placeholder="Message" rows="7"
                        data-form-field="Message"></textarea>
                    </div>
                    <div>
                      <button type="submit" class="contact-us">CONTACT US</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

    </main>



</body>

</html>