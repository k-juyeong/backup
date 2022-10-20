// const str = '내 이름은 홍길동입니다';
// console.log(str);


// const name = '홍길동';
// const str2 = '내 이름은 ' + name + '입니다';
// console.log(str2);

// //template literal
// const str3 = `내 이름은 ${name}입니다`;
// console.log(str3);

//taged template
const taged = (strings,exp1,exp2,exp3) =>{
    console.log(strings);
    console.log(exp1,exp2,exp3);
    

    return `${exp1}-${exp2}`;
}

const taged2 = (strings,...exp) =>{
    console.log(strings);

    const str = exp.map((ele, i) => `${ele}-${i}`)
                   .join();

    return str;
}

const name = '홍길동';
const age = 30;
const blood = 'A';
// const str4 = taged`내 이름은 ${name}이고 나이는 ${age}입니다.`;
const str4 = taged2`fdsf${name}fdsf${age}sfd${blood}4324`;

console.log(str4);