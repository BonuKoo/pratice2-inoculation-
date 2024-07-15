//입출고 등록 유효성 검사
//입출고 등록 유효성 검사
function registOrder(){
    const form = document.orderForm;
    const p_seno = form.p_seno.value;           //예방접종이력번호
    const t_cust = form.cust.value;             //고객번호
    const injection = form.injection.value;     //백신코드
    const p_date = form.p_date.value;           //접종일자

    if (p_seno == "") {
        window.alert("예방접종이력번호가 입력되지 않았습니다!");
        form.p_seno.focus();
        return;
    }
    if (t_cust == "") {
        window.alert("고객번호가 입력되지 않았습니다!");
        form.cust.focus();
        return;
    }
    if (injection == "") {
        window.alert("백신코드가 입력되지 않았습니다!");
        form.injection.focus();
        return;
    }
    if (p_date  == "") {
        window.alert("접종일자가 입력되지 않았습니다!");
        form.p_date.focus();
        return;
    }

    window.alert("입출고등록이 정상적으로 등록되었습니다.");
    form.submit();
}

//입출고 등록 다시쓰기
function resetOrder(){
	const form = document.orderForm;
	window.alert("정보를 지우고 처음부터 다시 입력 합니다.")
	orderForm.reset();
	orderForm.p_seno.focus();
}