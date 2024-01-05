/**
 * 
 */
 
 const del = document.getElementById("del");
 const frm = document.getElementById("frm");
 const up = document.getElementById("up");


up.addEventListener("click", function(){

    frm.setAttribute("action", "update");
    frm.setAttribute("method", "GET");
    frm.submit();

   // location.href="./update?region_id="+data-region-id;

})

 del.addEventListener("click", function(){
    let result = confirm("정말 지울거냐??");

    if(result){
        frm.submit();
    }

 });


