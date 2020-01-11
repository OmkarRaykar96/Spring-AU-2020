function validate(){
    var username=document.getElementById("username").value+"";
    var pass=document.getElementById("pass").value+"";
    var cpass=document.getElementById("cpass").value+"";
    
    var char8=document.getElementById("char8");
    var match=document.getElementById("match");
    var specialchar=document.getElementById("specialchar");
    var sequence=document.getElementById("sequence");
    var uclc=document.getElementById("uclc");
    var numero=document.getElementById("numero");
    var valid=true;

    hideAll();
    if(checkEmpty(username,pass,cpass)){
        alert("All Fields Mandatory;")
        return;
    }

    //pass length>8; pass=cp; 1 lower, 1 upper & 1 number; special characters (@,$,*);utf code; should contain abc
    if(pass.length < 8){
        char8.style.display="block";        
        valid=false;
    }

    if(pass != cpass){
        match.style.display="block";
        valid=false;
    }

    if(!(/[a-z]/.test(pass) && /[A-Z]/.test(pass)) ){
        uclc.style.display="block";
        valid=false;
    }

    if(!(/[@$*]/.test(pass))){
        specialchar.style.display="block";
        valid=false;
    }

    if(!(/[0-9]/.test(pass))){
        numero.stlye.display="block";
        valid=false;
    }
    
    if(!(/abc/.test(pass))){
        sequence.style.display="block";
        valid=false;
    }

    if(valid){
        alert("Successful!!!\nUsername: "+username+"\nPassword: "+pass);
    }
}

function hideAll(){
    char8.style.display="none";
    match.style.display="none";
    uclc.style.display="none";
    specialchar.style.display="none";
    sequence.style.display="none";
}

function checkEmpty(username,pass,cpass){
    if(username ==="" || pass === "" || cpass === "")
        return true;
    else
        return false;
}