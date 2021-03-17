<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container" data-ng-app = "cartApp">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product!</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png" /> " alt="image"
                             style="width:100%"/>
                </div>

                <div class="col-md-5">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <p>
                       <strong>Manufacturer</strong> : ${product.manufacturer}
                    </p>
                    <p>
                        <strong>Category</strong> : ${product.category}
                    </p>
                    <p>
                        <strong>Condition</strong> : ${product.condition}
                    </p>
                    <h4>${product.price} USD</h4>
                    
                    <br>
                    
                     <c:set var="role" scope="page" value="${param.role}" />
                    <c:set var="url" scope="page" value="/productList" />
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>

                    <p data-ng-controller="cartCtrl">
                        <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-large"
                           data-ng-click="addToCart('${product.productId}')"><span
                                class="glyphicon glyphicon-shopping-cart"></span>Order
                            Now</a>
                            <br>
                        <a href="<spring:url value="/cart" />"
                           class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
                    </p>
                    
                </div>
            </div>
        </div>
        
    

		<script src="<c:url value="/resources/js/controller.js" /> "></script>

        <%@include file="/WEB-INF/view/template/footer.jsp" %>
        
        </div>
        </div>