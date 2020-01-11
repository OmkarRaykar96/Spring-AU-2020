var names=["omkar raykar","rohit gonsalves","gaurav yadav","darshan patil","rohan pawar","abhigyan nayak","aakash niwane","sourabh koyande","mrinal maheshwari","shreyas mistry","pranay desai"];

function search(){
    var username=document.getElementById("uname").value;
    var userlist=document.getElementById("userlist");
    
    re = new RegExp(username);
    var filteredlist= names.filter(item => re.test(item));
    
    var str=filteredlist.toString();
    var str2=str.replace(/,/g, "\n");
    
    userlist.innerHTML =str2;
}

function sort(){
    var userlist=document.getElementById("userlist");
    var res = userlist.value.split("\n");
    res.sort();
    var str=res.toString();
    var str2=str.replace(/,/g, "\n");
    userlist.innerHTML =str2;
}