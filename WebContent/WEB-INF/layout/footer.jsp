<c:choose>
<c:when test="${empty sessionScope.currentUser}">
<footer class="op navbar-fixed-bottom">
</c:when>
<c:when test="${!empty sessionScope.currentUser}">
<footer class="op navbar-fixed-bottom">
</c:when>
</c:choose>

<!-- Footer -->


  <!-- Footer Links -->
  <div class="text-center text-md-left">


  <!-- Footer Links -->

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">2018 Copyright:
    <a href="https://mdbootstrap.com/education/bootstrap/"> movieswatch.com</a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->
</body>
</html>