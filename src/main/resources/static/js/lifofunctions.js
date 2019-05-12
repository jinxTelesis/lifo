
$(document).ready(function(){


    $('#selection').change(function(e){
        // this function runs when a user selects an option from a <select> element
        location = $("#selection option:selected").val();
        console.log($("#selection option:selected").val());
    });

    $('#sortorder').change(function(e){
        // this function runs when a user selects an option from a <select> element
        location = $("#sortorder option:selected").val();
        console.log($("#sortorder option:selected").val());
    });

    $('#registration').validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                minlength: 8
            },
            passwordconfirm: {
                minlength: 8,
                equalTo: "#password"
            },
            ssn: {
                required: true,
                rangelength: [8 - 11]
            }
        }, //end rules
        messages: {
            email: {
                required: "Please supply an e-mail address.",
                email: "This is not a valid email address."
            },
            password: {
                required: "Please provide a password",
                minlength: "Password must be at least 8 characters long."
            },
            passwordconfirm: {
                required: "Please provide a password",
                rangelength: "Password must be at least 8 characters long.",
                equalTo: "The two passwords do not match."
            }
        },
        errorPlacement: function(error, element) {
            if ( element.is(":radio") || element.is(":checkbox")) {
                error.appendTo( element.parent());
            } else {
                error.insertAfter(element);
            }
        }
    }); // end validate

    $('#dob').datepicker({
        changeMonth : true,
        changeYear : true,
        maxDate: new Date(2006,4,13),
        yearRange : '1920:2006',
        dateFormat : 'mm-dd-yy',
    });


    // function validateEmail(email) {
    //     var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    //     return re.test(email);
    // }

});