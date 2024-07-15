// js는 요소를 모두 객체로취급 vs jQuery는 모든 접근이 메소드로
// jQuery = > Native Dom (추상화) : 모든 문법의 결과가 대체로 jQuery
// jQuery 태그 탐색 : $('')
// => css selector # : id 속성
//                 . : class 속성
//                  tagName : tag 속성

//  [attribute] : 일반속성
//  => [attribute = 'value'] : 특정 속성 값이 value 인 경우
//  => [attribute^ = 'value'] :  특정 속성 값이 value 로 시작하는 경우
//  => [attribute$ = 'value'] :  특정 속성 값이 value 로 끝나는 경우
//  => [attribute* = 'value'] :  특정 속성 값이 value 를 포함하는 경우
// 
// :checked : checked 속성이 true인 태그 검색
// 공백 : 하위요소 (EX, tr input)   // 바로아래 아니어도 더 아래요소도 선택가능
// >    : 자식요소 (EX, tr > input)  // 바로아래요소
//  공백이 없는 경우 : 해당 태그가 특정 속성값을 가지는 경우(EX, table.list)
// 
// jQuery는 필드가 없음 접근은 아래처럼
// 부모 : parent()
// 자식 : children(),first(),last()
// 형제 : prev(), next()

$(function(){   //js의 DOMContentLoaded : jquery의 ready
    //DOM이 완성되는 경우 수행할 코드

    //on(): 이벤트 핸들러 등록 메소드
    //off():  이벤트 핸들러 삭제? 메소드
    $('#insertBtn').on('click', insertTrTag);
    //버튼중 아이디가 ajaxBtn 인것
    $('button#ajaxBtn').on('click', ajaxData);
    
    $('tbody > tr, [type="text"]').on('click',function(e){
        if(e.target.tagName == 'SELECT') return;

        // console.log('target Tag'. e.target);
        console.log('currentTarget Tag', e.currentTarget);
        console.log('this', this);
    })
});

function insertTrTag(event){
    // $('<tagName />');    //태그가 필요하면 태그정보 직접넣음innerHTML
    // or   =>>>> <>쓸때는 태그 생성시 꼭필요함 선택시는 필요X
    // $('<tagName id="name" class="sel input"></tagName>');

// innerHtml : html()
// textContent : text()
// class : addClass(), removeClass(), hasClass() 클래스가있는지, toggleClass()
// value : val()
// style : css()
// 기타 : attr(), prop()
    let trTag = $('<tr />');    //tr태그에 어떤속성도 안넣을거라<tr></tr>로 표시할 필요 X
    //체크박스
    let tdTag = $('<td/>');
    //기타속성(ex checkbox)쓸때 prop 주로씀 : 값 세팅할때
    let inputTag = $('<input/>').prop('type','checkbox');
    console.log('값을 가지고 오는경우 : ',inputTag.prop('type'));
    tdTag.append(inputTag);
    trTag.append(tdTag);
    // closet() : 가장가까운 조상 input.closet(tr) : input위에td있고그위에 tr있는경우 tr찾을때
    //          : 상위 요소 중 해당 조건을 만족하는 첫번째 태그
    
    //NO
    tdTag = $('<td/>').text(100);
    trTag.append(tdTag);

    //아이디
    trTag.append(
        $('<td/>').append(
            $('<input/>').prop('type','text').prop('name','id')
        )
    );

    //비밀번호
    // trTag.append(`<td><input type="password" name="password"></td>`);
    insertTag = $('<input>').prop('type','password').prop('name','password');
    tdTag = $('<td/>').append(insertTag);
    trTag.append(tdTag);

    //구분
    let firstOpt = $('<option/>').text('남자').val('Male');
    let secondOpt = $('<option/>').text('여자').val('Female');
    let selectTag = $('<select />').prop('name','gender')
                                    .append(firstOpt)
                                    .append(secondOpt)
    tdTag = $('<td/>').append(selectTag);
    trTag.append(tdTag);

    //이름
    // tdTag = $(`<td/><input type="text" ></td>`); => 이건 별로 쓰지마셈 단발성
    insertTag = $('<input/>').prop('type','text').prop('name','name');
    tdTag = $('<td/>').append(insertTag);
    trTag.append(tdTag);

    //가입날짜
    // tdTag = $(`<td/><input type="text" ></td>`);
    insertTag = $('<input/>').prop('type','date').prop('name','joinDate');
    tdTag = $('<td/>').append(insertTag);
    trTag.append(tdTag);

    $('tbody').append(trTag);
};
function ajaxData(event){
    let userAry = getCheckedUsers();

    printTable();
};

function printTable(){
    let table = $('table');

    console.log(table.html());
    console.log(table.text());
    console.log(table.find('input[type="password"]').val());
    console.log(table.css('border'));
    $('table tr:even').css('background-color','skyblue');
    console.log(table.find('select:eq(1)').prop('name'));

}

function getCheckedUsers(){
    // let chList = $('input').find(':checked').not('#allChk');
    // let chList = $('input[type="radio"]').filter(':checked').not('#allChk');
    // input 태그중에서 checked된것
    let chList = $('input:checked').not('#allChk');
    console.log('chList[0] : ',chList[0].type);
    //each 첫번째 가져오는거 index 두번째는 값 항상 두번째 값까지 가져와야함
    let array = [];
    chList.each((idx,tag)=>{    //each 안에서쓰는 내용은 js요소들임
        // 🍟가장중요🍟) 반복문 안에서 jQuery는 깨짐
        //                  자바스크립트 문법을 사용해야함                            
        console.log('idx : ', idx);
        console.log('tag : ',tag);
        //해당 tag 변수를 활용해서 <tr/> 태그를 찾아 trTag변수에 담기
        let trTag = tag.closest('tr');
        //trTag 변수를 활용해서 하위 요소 중 입력태그를 검색하기
        //querySelectorAll 는 document에서만 말고 태그에서도 검색가능
        // 태그 여러개 ,이용해서 검색가능
        let dataTag = trTag.querySelectorAll('input, select');    //find못씀 js객체기때문에 js에서 find는 배열에서만 사용가능
        
        let obj = {};
        dataTag.forEach(tag =>{ // forEach는 continue,break 사용못함
            if(tag.name =='') return;
            obj[tag.name] = tag.value;
        });
        array.push(obj);
    });
    console.log(array);
    return array;
};











