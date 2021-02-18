function handleSerial(s){
    if(s.length>1){
        for(let i=0; i<s.length-1;i++){  //用到i+1,所以i<s.length-1
            for(let j=i+1; j<s.length;j++){ //从i+1开始比对
                if(s[i].code== s[j].code){
                    s.splice(j,1); //删除j位置的数据项，就有后面的元素替补，所以要退一步
                    j--;
                }
            }
        }
    }
    console.log(s);
    return s;
}