
function handleSerial(s){
    if(s.length>1){
        for(var i=0; i<s.length-1;i++){
            for(var j=i+1; j<s.length;j++){
                if(s[i].serial== s[j].serial){
                    s.splice(j,1);
                    j--;
                }
            }
        }
    }
    console.log(s);
    return s;
}