

const Person = {
    name: '홍길동',
    age: 30
}

{
    // Person 객체를 매개값으로 받아서 출력

    function printPerson(obj) {
        const name = obj.name;
        const age = obj.age;
        console.log(name,age);
    }

    printPerson(Person);
}

{
    // 화살표 함수

    const printPerson = (obj) => {
        const name = obj.name;
        const age = obj.age;
        console.log(name,age);
    }

    printPerson(Person);
}

{
    // 화살표 함수 + 객체 디스트럭처링

    const printPerson = ({name,age}) => console.log(name,age);
    printPerson(Person);
}