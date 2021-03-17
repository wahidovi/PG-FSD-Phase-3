<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="POST"
                   modelAttribute="product" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Name</label>	
            <form:input path="name" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="category" id="category"
                                                             value="Sport Shoes" />Sport Shoes</label>
            <label class="checkbox-inline"><form:radiobutton path="category" id="category"
                                                             value="Hiking Shoes" />Hiking Shoes</label>
            <label class="checkbox-inline"><form:radiobutton path="category" id="category"
                                                             value="Casual Shoes" />Casual Shoes</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="description" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="price" id="price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="condition" id="condition"
                                                             value="new" />New</label>
            <label class="checkbox-inline"><form:radiobutton path="condition" id="condition"
                                                             value="used" />Used</label>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="status" id="status"
                                                             value="active" />Active</label>
            <label class="checkbox-inline"><form:radiobutton path="status" id="status"
                                                             value="inactive" />Inactive</label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="manufacturer" id="manufacturer" class="form-Control"/>
        </div>

		 <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
        </div>
        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/view/template/footer.jsp" %>
        
        </div>
        </div>