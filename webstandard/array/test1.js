
        const data = {
            result:'success',    // success: 수신성공, fail:수신실패
            data:[
              {name:'이름1',gender:'남',age:10,blood:'A'},
              {name:'이름2',gender:'여',age:20,blood:'B'},
              {name:'이름3',gender:'남',age:30,blood:'O'},
              {name:'이름4',gender:'여',age:40,blood:'AB'},
              {name:'이름5',gender:'남',age:50,blood:'A'}
            ]
          };
          //0. 회원의 수
          {
            if(data.result == 'success'){
              console.log(data.data.length);  
            }
          }
          //1. 회원이름을 콘솔에 출력하기
          {
            if(data.result == 'success'){
              data.data.forEach(ele=>console.log(ele.name));
            }
          }
          //2. 회원 나이의 총합 출력하기
          {
            let sum = 0;
            data.data.forEach(ele=> sum+=ele.age);
            console.log(`회원 나이의 총합 : ${sum}`);
          }
          
          {
            const result = data.data.reduce((acc,ele)=>acc+ele.age,0);                                                                  
            console.log(`회원 나이의 총합 : ${result}`);
          }
          
          //3. 남자회원의 나이 총합 출력하기
          {
            let sumOfMen = 0;
            data.data.filter(ele => ele.gender == '남').forEach(ele => sumOfMen += ele.age);
            console.log(`남자회원 나이의 총합 : ${sumOfMen}`);
          }
          
          {
            const sumOfMen2 = data.data.filter(ele => ele.gender == '남').reduce((acc,ele)=> acc+ele.age,0);
            console.log(`남자회원 나이의 총합 : ${sumOfMen2}`);
          }

          {
            const result = data.data.filter((ele,idx,arr)=>ele.gender == '남');
            console.log(result);
            const final = result.reduce((acc,ele,idx,arr)=>acc + ele.age,0);

            console.log(`남자회원 나이의 총합 : ${final}`);
          }


          //4. 남자회원, 여자회원을 분리하여 배열에 저장
          {
            var men = [];
            var women = [];
            data.data.forEach(ele => {
                if(ele.gender == '남'){
                    men.push(ele);
                }else {
                    women.push(ele);
                }
            })
            console.log(men, women);
          }
          
          {
            const men2 = data.data.map(ele => ele).filter(ele => ele.gender == '남');
            const women2 = data.data.map(ele => ele).filter(ele => ele.gender == '여');
            console.log(men2, women2);
          }

          {
            var men3=[];
            var women3=[];
            data.data.filter(ele => ele.gender == '남').forEach(ele => men3.push(ele));
            data.data.filter(ele => ele.gender == '여').forEach(ele => women3.push(ele));
            console.log(men3,women3);
          }

          {
            const men4 = data.data.filter(ele => ele.gender == '남');
            const women4 = data.data.filter(ele => ele.gender == '여');
            console.log(men4,women4);
          }

          {
            const men5 = data.data.reduce((acc,ele,idx,arr)=>{
                                if(ele.gender == '남') acc.push(ele);
                                return acc;
                            },[]);

            const women5 = data.data.reduce((acc,ele,idx,arr)=>{
                                if(ele.gender == '여') acc.push(ele);
                                return acc;
                            },[]);
            console.log(men5, women5);
          }

          //5. A형 회원의 나이 총합 구하기
          {
            let sumOfBloodA = 0;
            data.data.filter(ele => ele.blood == 'A').forEach(ele => sumOfBloodA += ele.age);
            console.log(`A형 회원 나이의 총합 : ${sumOfBloodA}`);
          }
          
          {
            const sumOfBloodA2 = data.data.filter(ele => ele.blood == 'A').reduce((acc,ele)=> acc+ele.age,0);
            console.log(`A형 회원 나이의 총합 : ${sumOfBloodA2}`);
          }

          //6. name이 이름3인 회원의 혈액형은?
          {
            let bloodType = '';
            data.data.filter(ele => ele.name == '이름3').forEach(ele => bloodType = ele.blood);
            console.log(`이름3 회원의 혈액형 : ${bloodType}`);
          }

          {
            const result = data.data.filter(ele => ele.name == '이름3');
            console.log(`name이 이름3인 회원이 혈액형 : ${result[0].blood}`)
          }

        //7. 혈액형별 인원수 카운트
        //  결과 : {A:2, B:1, O:1, AB:1}
        {
            const countOfBloodType =
                  data.data.reduce((acc,ele,idx,arr) => {
                    //같은 혈액형 프로퍼티 누적
                    //case1)
                    // if(acc[ele.blood]) {
                    //     ++acc[ele.blood];
                    // } else {
                    //     acc[ele.blood]=1;
                    // }
                    //case2)
                    // acc[ele.blood] = acc[ele.blood] ? ++acc[ele.blood] : 1;
                    //case3)
                    acc[ele.blood] = (acc[ele.blood] || 0) + 1;

                    return acc
            },{});
            console.log(countOfBloodType);
        }  

        //8. 남성 회원의 평균 연령
        {
            //case1)
            // const avgAgeOfMen = data.data.filter(ele => ele.gender == '남')
            //                         .reduce((acc,ele,idx,arr)=> {
                                        // if(idx == arr.length-1) {
                                        //     return (acc+ele.age)/arr.length;
                                        // }
                                        // return acc+ele.age;
                                    // });
            //case2)
            const avgAgeOfMen = data.data.filter(ele => ele.gender == '남')
                                    .reduce((acc,ele,idx,arr)=>
                                        idx == arr.length-1 ? (acc+ele.age)/arr.length : acc+ele.age,0);
                                        // return acc+ele.age/arr.length;
            console.log(`남성 회원의 평균 연령 : ${avgAgeOfMen}`);
        }

        //9. 나이가 가장 많은 회원의 혈액형은?

        {
            // const bloodTypeOfTheOldest =
            //     data.data.reduce((acc,ele,idx,arr)=> {
                    //case1)
                    // if(acc < ele.age) {
                    //     acc = ele.age;
                    // }
                    // return acc;
                // },0);


            const bloodTypeOfTheOldest = 
                data.data.reduce((acc,ele,idx,arr) => (acc.age <ele.age) ? ele : acc);


                console.log(`나이가 가장 많은 회원의 혈액형 : ${bloodTypeOfTheOldest.blood}`);
        }

        //10.
        //[
        //  {name:'이름1',age:10},
        //  {name:'이름2',age:20},
        //  {name:'이름3',age:30},
        //  {name:'이름4',age:40},
        //  {name:'이름5',age:50}
        // ]
        {
            const processedData = 
                data.data.reduce((acc,ele)=> {
                    acc.push({name:ele.name, age:ele.age});
                    return acc;
                }, []);

            console.log(processedData);
        }
        //11. 수신된 데이터에 남자회원이 있는지 여부
        {
          const isExist = 
            data.data.some((ele,idx,arr)=> ele.gender == '남');
            console.log(`남자회원이 있는지 여부 ${isExist}`);
        }

        //12. 수신된 데이터가 모두 남자회원인지 여부
        {
          const isExist = 
            data.data.every((ele,idx,arr)=>ele.gender == '남');
            console.log(`모두 남자회원인지 여부 ${isExist}`);
        }
        
        //13. 여성회원을 나이 내림차순으로 정렬하기
        {
          const sortedMember = 
                  data.data.filter(ele => ele.gender == '여')
                          .sort((e1,e2)=>e2.age-e1.age);
          console.log(sortedMember);
        }

        //14. 여성이면서 혈액형이 'AB'인 첫번째 회원의 이름은?
        {
          let name = data.data.filter(ele => ele.gender == '여' && ele.blood == 'AB')[0].name;
          console.log(name);

          name = data.data.find(ele=> ele.gender == '여' && ele.blood == 'AB').name;
          console.log(name);
        }