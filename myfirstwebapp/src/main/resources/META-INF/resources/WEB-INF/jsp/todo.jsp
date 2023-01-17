<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
<div class="container">
		<h1>Enter Todo Details</h1>
		<form:form method="post" modelAttribute="todo">

			<fieldset class="mb-3">
				<form:label for="description" path="description">Description: </form:label>
				<form:input type="text" id="description" path="description"
					required="required" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label for="targetDate" path="targetDate">Target Date: </form:label>
				<form:input type="text" id="targetDate" path="targetDate"
					required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>

			<form:hidden path="id" />
			<form:hidden path="done" />
			<input type="submit" class="btn btn-success" value="Submit">
		</form:form>
</div>
<%@ include file="common/footer.jspf" %>

<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>

