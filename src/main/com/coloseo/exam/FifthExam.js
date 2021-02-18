function Tree(s){
    let ind = 0 ; //判断第一层是不是还有子树
    if(s.length>1){
        for(let i=0;i<s.length;i++){
            let a = 0;  //计数信号量
            for(let j=i+1;j<s.length;j++){
                if(s[j].parent == s[i].code){//判断是否有子树
                    a++;  //子树计数
                    ind++;
                }
            }
            if(a == 0&&s[i].parent!=''){ //没有子树，即树的最底层
                for(let n in s){
                    //定义children，避免undefined
                    s[n].children = s[n].children?s[n].children:[];
                    if(s[n].code == s[i].parent){
                        s[n].children.push(s[i]);
                    }
                }
                s.splice(i,1);//删除，该子树已经加入了某项底层
                i--; //删掉子树后后面的数据会填补空缺，退一步才能遍历完全
            }
        }
        if(ind != 0){ //如果还有子树继续遍历第一层
            Tree(s);
        }
    }
    return s;
}
function handleTree(s){
    s = Tree(s);
    console.log(s);
    return s;
}