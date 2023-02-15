function updateBtn(num){
		
		const text_change = document.getElementById('update?'+num)
		const update_Btn = document.getElementById('updateBtn?'+num)
		const delete_Btn = document.getElementById('deleteBtn?'+num)
		text_change.removeAttribute('readonly')
		text_change.removeAttribute('class')
		update_Btn.setAttribute("class", 'unUseBtn')
		delete_Btn.setAttribute("class", 'unUseBtn')
		
		const div = document.getElementById('appendBtn?'+num);
		
		const newBtnUpdate = document.createElement("button")
        newBtnUpdate.innerHTML="수정완료"
        newBtnUpdate.setAttribute("onclick",'newUpdateBtn('+num+')')
        newBtnUpdate.setAttribute("style","font-size: 1.5rem; width: max-content")
        div.appendChild(newBtnUpdate)
		
        const btnCancle = document.createElement("button")
        btnCancle.innerHTML="수정취소"
		btnCancle.setAttribute("type","button")
        btnCancle.setAttribute("onclick",'cancleBtn()')
        btnCancle.setAttribute("style","font-size: 1.5rem; width: max-content")
        div.appendChild(btnCancle)
	
	}
function cancleBtn(num){
	
		window.location.reload();
	
}

function newUpdateBtn(num){
	
	const reno = num	
	const text_change = document.getElementById('update?'+num).value
	
	const reply = {
		reno  : reno,
		rememo : text_change,
	}
	
	const URL = "/board/api/update"
	
	fetch(URL,{
			method : "PUT",
            body : JSON.stringify(reply),
            headers : {
                "Content-Type": "application/json"
            },
		}).then(Response=>{
			if(Response.ok){
				alert('수정완료')
				window.location.reload();
			}else{
				alert('수정실패')
				window.location.reload();
			}
		})
	
	}
