function reserve(s){
    if(s.length <= 1){
        return s;
    }
    let one = s.charAt(0);
    s = s.substring(1);
    return reserve(s) + one;
}
