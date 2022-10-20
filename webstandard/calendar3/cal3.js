window.onload = function () {    
    let today = new Date();
    const calendarBody = document.querySelector('.calendar-body');
    const prevEl = document.querySelector('.prev');
    const nextEl = document.querySelector('.next');
    const inputBox = document.querySelector('.input-box');
    const inputBtn = document.querySelector('.input-btn');
    const inputList = document.querySelector('.todoList');
    const showList = document.querySelector('.showList');
    const listText = document.querySelector('.listText');
    const createDate = document.querySelector('.createDate');
    const bgblack = document.querySelector('.bgblack');
    const closedBtn = document.querySelector('.closed');
    let currentDate;
    
    
    buildCalendar();
    
    function buildCalendar() {
        let firstDate = new Date(today.getFullYear(), today.getMonth(), 1);
        const monthList = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
        const leapYear = [31,29,31,30,31,30,31,31,30,31,30,31];
        const notLeapYear = [31,28,31,30,31,30,31,31,30,31,30,31];
        const headerYear = document.querySelector('.current-year-month');
        //  윤년 체크
        if (firstDate.getFullYear()%4 === 0) {
            pageYear = leapYear;
        } else {
            pageYear = notLeapYear;
        }
    
        headerYear.innerHTML = `${monthList[firstDate.getMonth()]}&nbsp;&nbsp;&nbsp;&nbsp;${today.getFullYear()}`;
        makeElement(firstDate);
        showMain();
        currentDateget();
        resetInsert();
    
    }
    
    function showMain() {
        const mainDay = document.querySelector('.main-day');
        const mainDate = document.querySelector('.main-date');
        const dayList = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        mainDay.innerHTML = dayList[today.getDay()];
        mainDate.innerHTML = today.getDate();
    }
    
    function makeElement(firstDate) {
        let weekly = 100;
        let Currentdate = 1;
        for(let i=0; i<6; i++) {
            let weeklyEl = document.createElement('div');
            weeklyEl.setAttribute('class', weekly);
            weeklyEl.setAttribute('id', "weekly");
            for(let j=0; j<7; j++) {
                if(i===0 && j<firstDate.getDay() || Currentdate>pageYear[firstDate.getMonth()]) {
                    let dateEl = document.createElement('div');
                    weeklyEl.appendChild(dateEl);
                } else {
                    let dateEl = document.createElement('div');
                    dateEl.textContent = Currentdate;
                    dateEl.setAttribute('class', Currentdate);
                    dateEl.setAttribute('id', `${today.format2()}-${Currentdate}`);
                    weeklyEl.appendChild(dateEl);
                    Currentdate++;
                }
            }
            weekly++;
            calendarBody.appendChild(weeklyEl);
        }
        let clickedDate = document.getElementsByClassName(today.getDate());
        clickedDate[0].classList.add('active');
    }
    
    function removeCalendar() {
        let divEls = document.querySelectorAll('.calendar-body > #weekly > div');
        for (let i = 0; i < divEls.length; i++) {
          divEls[i].remove();
        }
    }
    
    
    function showMain() {
        const mainDay = document.querySelector('.main-day');
        const mainDate = document.querySelector('.main-date');
        const dayList = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        mainDay.innerHTML = dayList[today.getDay()];
        mainDate.innerHTML = today.getDate();
    }
    
    prevEl.addEventListener('click', function() {
        today = new Date(today.getFullYear(), today.getMonth()-1, today.getDate());
        removeCalendar();
        buildCalendar();
        resetInsert();
        redrawLi();
    });
    
    nextEl.addEventListener('click', function () {
        today = new Date(today.getFullYear(), today.getMonth()+1, today.getDate());
        removeCalendar();
        buildCalendar();
        resetInsert();
        redrawLi()
    })
    
    
    function currentDateget() {
        // format()을 이용해서 현재 날짜를 보기좋게 출력해주기 위해 사용.
        currentDate = today.format();
    }
    
    calendarBody.addEventListener('click', function (e) {
        let target = e.target;
        let eachDate = document.querySelectorAll('.calendar-body > #weekly > div');
        if (e.target.innerHTML === '') return;
        for (let i = 0; i < eachDate.length; i++) {
          eachDate[i].classList.remove('active');
        }
        target.classList.add('active');
        today = new Date(today.getFullYear(), today.getMonth(), target.innerHTML);
        showMain();
        currentDateget();
        redrawLi();
        resetInsert();
    });
    
    inputBtn.addEventListener('click', function (e) {
        e.preventDefault();
        let inputValue = inputBox.value;
        insertTodo(inputValue);
    });
    
    // 할일 저장
    function insertTodo(text) {
        let todoObj = {
            todo: text,
        }
    
        if(!DATA[currentDate]) {
            DATA[currentDate] = [];
            DATA[currentDate].push(todoObj);
        } else {
            DATA[currentDate].push(todoObj);
        }
    
        const liEl = document.createElement('li');
        const spanEl = document.createElement('span');
        const delBtn = document.createElement('button');
        delBtn.innerText = "DEL";
        delBtn.setAttribute('class', 'del-data');
        spanEl.innerHTML = text;
        liEl.appendChild(spanEl);
        liEl.appendChild(delBtn);
        inputList.appendChild(liEl);
        liEl.setAttribute('id', DATA[currentDate].length);
        delBtn.addEventListener('click', delWork);
        liEl.addEventListener('dblclick', showTodo);
    
        todoObj.id = DATA[currentDate].length;
        save();
        inputBox.value = '';
    }
    function redrawLi() {
        // 다른 날짜를 클릭했을때 그 전에 작성한 totolist목록을 먼저 다 지우기 위해 li와 span을 찾아와 for문으로 지워주고 다시 그려준다.
        let liEl = document.querySelectorAll('LI');
        for (let i = 0; i < liEl.length; i++) {
          inputList.removeChild(liEl[i]);
        }
        for (let todoList in DATA) {
          if (todoList === currentDate) {
            for (let i = 0; i < DATA[todoList].length; i++) {
              const liEl2 = document.createElement('li');
              const spanEl2 = document.createElement('span');
              const delBtn2 = document.createElement('button');
              delBtn2.innerText = "DEL";
              delBtn2.setAttribute('class', 'del-data');
              spanEl2.innerHTML = DATA[todoList][i].todo;
              liEl2.appendChild(spanEl2);
              liEl2.appendChild(delBtn2);
              inputList.appendChild(liEl2);
              liEl2.setAttribute('id', DATA[todoList][i].id);
              delBtn2.addEventListener('click', delWork);
              liEl2.addEventListener('dblclick', showTodo);
            }
          }
        }
    }
    function resetInsert() {
        let storeObj = localStorage.getItem(currentDate);
        if(storeObj !== null) {
            let liEl = document.querySelector('LI');
            for(let i=0; i<liEl.length; i++) {
                inputList.removeChild(liEl[i]);
            }
    
            const parsed = JSON.parse(localStorage.getItem(currentDate));
    
            parsed.forEach(function (todo) {
                if(todo) {
                    let lili = document.createElement('li');
                    let spanspan = document.createElement('span');
                    let deldel = document.createElement('button');
                    deldel.setAttribute('class', 'del-date');
                    deldel.innerText = "DEL";
                    lili.setAttribute('id', todo.id);
                    spanspan.innerHTML = todo.todo;
                    lili.appendChild(spanspan);
                    lili.appendChild(deldel);
                    inputList.appendChild(lili);
                    deldel.addEventListener('click', delWork);
                    lili.addEventListener('dblclick', showTodo);
                }
            });
        }
    }
    resetInsert();
    
    function delWork(e) {
        e.preventDefault();
        let delParentLi = e.target.parentNode;
        inputList.removeChild(delParentLi);
        const cleanToDos = DATA[currentDate].filter(function (todo) {
            return todo.id !== parseInt(delParentLi.id);
        });
        DATA[currentDate] = cleanToDos;
        save();
    }
    function showTodo(e){
        showList.style.display = "block"
        bgblack.style.display = "block"
        listText.textContent = e.target.textContent;
        createDate.textContent = currentDate;
      }
    
      closedBtn.addEventListener('click', function(e){
        showList.style.display = "none";
        bgblack.style.display = "none";
      });
    function save() {
        localStorage.setItem(currentDate, JSON.stringify(DATA[currentDate]));
    }
    
}
