let date = new Date();

const createCalendar = ()=> {
    const viewYear = date.getFullYear();
    const viewMonth = date.getMonth();

    document.querySelector('.calendar__selected-month').textContent = `${viewYear}년 ${viewMonth+1}월`

    // 지난달, 다음달 일부 날짜 표시
    const prevLast = new Date(viewYear, viewMonth, 0);
    const thisLast = new Date(viewYear, viewMonth+1, 0);

    const prevLastDate = prevLast.getDate();
    const prevLastDay = prevLast.getDay();

    const thisLastDate = thisLast.getDate();
    const thisLastDay = thisLast.getDay();

    const prevLastDates = [];
    const thisLastDates = [...Array(thisLastDate+1).keys()].slice(1);
    const nextDates = [];

    // 지난달 일부 날짜 표시
    if(prevLastDay !== 6) {
        for(let i=0; i<prevLastDay + 1; i++){
            prevLastDates.unshift(prevLastDate-i);
        }
    }

    // 다음달 일부 날짜 표시
    for(let i=1; i<7-thisLastDay; i++) {
        nextDates.push(i);
    }

    const dates = prevDates.concat(thisLastDates, nextDates);
    const firstDateIndex = dates.indexOf(1);
    const lastDateIndex = dates.lastIndexOf(thisLastDate);

    dates.forEach((ele, idx)=> {
        const thisOrOther = idx >= firstDateIndex && idx < lastDateIndex + 1 ? 'this' : 'other';
    
        dates[idx] = `<div class="calendar__main-date"><span class="${thisOrOther}">${ele}</span></div>`
    })

    document.querySelector('.calendar__main-dates').innerHTML = dates.join('');

    const today = new Date();
    if(viewMonth === today.getMonth() && viewYear === today.getFullYear()) {
        for(let date of document.querySelectorAll('.this')) {
            if(+date.innerText === today.getDate()) {
                date.classList.add('today');
                break;
            }
        }
    }
}

createCalendar();


const $goPrev = document.querySelector('.btn.btn__nav-prev');
$goPrev.addEventListener('click', prevMonth = () => {
    date.setDate(1);
    date.setMonth(date.getMonth() - 1);
    createCalendar();
});

const $goToday = document.querySelector('.btn.btn__nav-today');
$goToday.addEventListener('click', thisMonth = () => {
    date = new Date();
    createCalendar();
});

const $goNext = document.querySelector('.btn.btn__nav-next');
$goNext.addEventListener('click', nextMonth = () => {
    date.setDate(1);
    date.setMonth(date.getMonth() + 1);
    createCalendar();
});

