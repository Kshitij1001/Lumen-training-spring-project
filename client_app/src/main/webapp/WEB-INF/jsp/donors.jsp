<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>
        Donors
    </title>

    <style type="text/css">
        *, *:before, *:after {
            box-sizing: border-box;
        }

        html {
            overflow-y: scroll;
        }

        body {
            background: #c1bdba;
            font-family: 'Titillium Web', sans-serif;
        }

        a {
            text-decoration: none;
            color: #1ab188;
            transition: .5s ease;
        }

        a:hover {
            color: #179b77;
        }

        .form {
            background: rgba(19, 35, 47, 0.9);
            padding: 40px;
            max-width: 800px;
            margin: 40px auto;
            border-radius: 4px;
            box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
        }

        .tab-group {
            list-style: none;
            padding: 0;
            margin: 0 0 40px 0;
        }

        .tab-group:after {
            content: "";
            display: table;
            clear: both;
        }

        .tab-group li a {
            display: block;
            text-decoration: none;
            padding: 15px;
            background: rgba(160, 179, 176, 0.25);
            color: #a0b3b0;
            font-size: 20px;
            float: left;
            width: 50%;
            text-align: center;
            cursor: pointer;
            transition: .5s ease;
        }

        .tab-group li a:hover {
            background: #179b77;
            color: #ffffff;
        }

        .tab-group .active a {
            background: #1ab188;
            color: #ffffff;
        }

        .tab-content > div:last-child {
            display: none;
        }

        h1 {
            text-align: center;
            color: #ffffff;
            font-weight: 300;
            margin: 0 0 40px;
        }

        label {
            color: white;
        }

        textarea {
            width: max-content;
            margin-top: 2%;
        }

        input[type="email"][type="password"] {
            width: max-content;
        }

        input {
            margin-top: 2%;
            margin-bottom: 2%;
        }

        .button {
            margin-top: 5%;
            border: 0;
            outline: none;
            border-radius: 0;
            padding: 15px 0;
            font-size: 2rem;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: .1em;
            background: #1ab188;
            color: #ffffff;
            transition: all 0.5s ease;
            -webkit-appearance: none;
        }

        .button:hover, .button:focus {
            background: #179b77;
        }

        .button-block {
            display: block;
            width: 100%;
        }

        .block {
            display: block;
        }

        .inline {
            display: inline;
        }
    </style>
</head>
<body>
<div class="form">

    <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
    </ul>

    <div class="tab-content">
        <div id="signup">
            <h1>Sign up as a <span style="color: red">Blood</span> Donor</h1>

            <%--@elvariable id="donor" type="java"--%>
            <form:form action="${pageContext.request.contextPath}/donors/register" onsubmit="return register()"
                       method="post" modelAttribute="donor">

                <div class="block">
                    <div class="inline">
                        <label>
                            First Name
                            <form:input path="firstName" type="text" required="" autocomplete="off" style="width:35%"/>
                        </label>
                    </div>

                    <div class="inline" style="margin-left:5%">
                        <label>
                            Last Name
                            <form:input path="lastName" type="text" required="" autocomplete="off" style="width:35%"/>
                        </label>
                    </div>
                </div>

                <div class="block">
                    <div class="inline">
                        <label>
                            Blood Group
                            <form:input path="bloodGroup" list="bldgrp" style="width:33.5%"/>
                            <datalist id="bldgrp">
                                <option value="A+">A+</option>
                                <option value="A-">A-</option>
                                <option value="AB+">AB+</option>
                                <option value="AB-">AB-</option>
                                <option value="B+">B+</option>
                                <option value="B-">B-</option>
                                <option value="O+">O+</option>
                                <option value="O-">O-</option>
                            </datalist>
                        </label>

                    </div>

                    <div class="inline" style="margin-left:5%">
                        <label>
                            Date of Birth
                            <form:input id="DoB" path="dob" style="width:33%" type="date" required=""
                                        autocomplete="off"/>
                        </label>
                    </div>
                </div>

                <div class="block" style="margin-left:13%">
                    <label>
                        Email ID
                        <form:input path="mail" type="email" style="width:87%" required="" autocomplete="off"/>
                    </label>
                </div>

                <div class="block" style="margin-left:13%">
                    <label>
                        Address
                        <form:textarea path="address" required="" autocomplete="off" cssStyle="width:87%"/>
                    </label>
                </div>

                <div class="block">
                    <label>
                        Set a Password
                        <form:input path="password" type="password" required="" autocomplete="off" style="width:30%"/>
                    </label>
                </div>

                <button type="submit" class="button button-block">Register Now!</button>

            </form:form>

        </div>

        <div id="login">
            <h1>Welcome Donor!</h1>

            <%--@elvariable id="donorCred" type="java"--%>
            <form:form action="${pageContext.request.contextPath}/donors/login" method="post"
                       modelAttribute="donorCred" onsubmit="return login()">

                <div class="field-wrap">
                    <label>
                        Email ID
                        <form:input path="email" type="email" required="" autocomplete="off" style="width: 60%"/>
                    </label>
                </div>

                <div class="field-wrap">
                    <label>
                        Password
                        <form:input path="pass" type="password" required="" autocomplete="off" style="width: 58.5%"/>
                    </label>
                </div>

                <button type="submit" class="button button-block">Log In</button>

            </form:form>

        </div>

    </div><!-- tab-content -->

</div> <!-- /form -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">

    let register = () => {
        const inputs = $('input');
        for (let i = 0; i < inputs.length - 2; i++) {        //last 2 elements r from login form
            inputs[i].value = inputs[i].value.trim();
            if (inputs[i].value.length === 0) {
                alert('no input should be empty');
                return false;
            }
        }
        if ($('#address').val($('textarea').val().trim()).val() === "") {
            alert("address shouldn't be empty");
            return false;
        }

        if ($('#password').val().length < 8) {
            alert('password should be minimum 8 characters long');
            return false;
        }
        return true
    };

    let login = () => {
        if ($('#email').val().length * $('#pass').val($("#pass").val().trim()).val().length === 0) {
            alert('no input should be empty');
            return false
        }
        if ($(`#pass`).val().length < 8) {
            alert('invalid password')
            return false;
        }
        return true
    };

    $('.form').find('input, textarea').on('keyup blur focus', function (e) {

        const $this = $(this),
            label = $this.prev('label');

        if (e.type === 'keyup') {
            if ($this.val() === '') {
                label.removeClass('active highlight');
            } else {
                label.addClass('active highlight');
            }
        } else if (e.type === 'blur') {
            if ($this.val() === '') {
                label.removeClass('active highlight');
            } else {
                label.removeClass('highlight');
            }
        } else if (e.type === 'focus') {

            if ($this.val() === '') {
                label.removeClass('highlight');
            } else if ($this.val() !== '') {
                label.addClass('highlight');
            }
        }

    });

    $('.tab a').on('click', function (e) {

        e.preventDefault();

        $(this).parent().addClass('active');
        $(this).parent().siblings().removeClass('active');

        const target = $(this).attr('href');

        $('.tab-content > div').not(target).hide();

        $(target).fadeIn(600);

    });
</script>

</body>
</html>