
const Functions = {
    categorySort: (arr) => {
        arr.sort(function(a,b){
            const A = a.layer;
            const B = b.layer;
            if (A < B) return -1;
            return 1;
        });
        return arr;
    }
}

export default Functions;