
// $("#submit").click(function()
// {
//     console.log("aa")
//     $.ajax({
//         dataType: "json",
//         type: "post",
//         url: "http://localhost:8080/report/add",
//         data: {
//             data : JSON.stringify($("#form").serialize())
//         },
//         success: function(res)
//         {
//             console.log(res)
//         },
//         error: function()
//         {
//             console.error("error!")
//         }     
    
//     })
// })
function upload()
{
    console.log("A")
    $.ajax({
        dataType: "JOSN",
        type: "post",
        url: "http://localhost:8080/report/add",
        data: {
            street: $("#street").val(),
            location: $("#location").val(),
            size: $("#size").val(),
            district: $("#district").val(),
            phone: $("#phone").val(),
            address: $("#address").val()

        },
        success: function(res)
        {
            console.log(res)
        },
        error: function()
        {
            
            console.error("error!")
        }     
    
    })
}

