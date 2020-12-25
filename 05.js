let json = [
    {
      "id": "1",
      "name": "中国",
      "code": "110",
      "parent": ""
    },
    {
      "id": "2",
      "name": "北京市",
      "code": "110000",
      "parent": "110"
    },
    {
      "id": "3",
      "name": "河北省",
      "code": "130000",
      "parent": "110"
    },
    {
      "id": "4",
      "name": "四川省",
      "code": "510000",
      "parent": "110"
    },
    {
      "id": "5",
      "name": "石家庄市",
      "code": "130001",
      "parent": "130000"
    },
    {
      "id": "6",
      "name": "唐山市",
      "code": "130002",
      "parent": "130000"
    },
    {
      "id": "7",
      "name": "邢台市",
      "code": "130003",
      "parent": "130000"
    },
    {
      "id": "8",
      "name": "成都市",
      "code": "510001",
      "parent": "510000"
    },
    {
      "id": "9",
      "name": "简阳市",
      "code": "510002",
      "parent": "510000"
    },
    {
      "id": "10",
      "name": "武侯区",
      "code": "51000101",
      "parent": "510001"
    },
    {
      "id": "11",
      "name": "金牛区",
      "code": "51000102",
      "parent": "510001"
    }
  ];
function Tree(s){
    let ind = 0 ;
    if(s.length>1){
        for(let i=0;i<s.length;i++){
            let a = 0;
            for(let j=i+1;j<s.length;j++){
                if(s[j].parent == s[i].code){
                    a++;
                    ind++;
                }
            }
            if(a == 0&&s[i].parent!=''){
                for(let n in s){
                    s[n].children = s[n].children?s[n].children:[];
                    if(s[n].code == s[i].parent){
                        s[n].children.push(s[i]);
                    }
                }
                s.splice(i,1);
                i--; 
            }
        }
        if(ind != 0){
            Tree(s);
        }
    }
    return s;
}
function newTree(s){ 
    s = Tree(s);
    console.log(s);
    return s;
}

newTree(json)