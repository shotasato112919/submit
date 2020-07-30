/*--------------------------------------------------------------------------*
 *  
 *  SmoothScroll JavaScript Library beta2
 *  
 *  MIT-style license. 
 *  
 *  2007-2010 Kazuma Nishihata 
 *  http://www.to-r.net
 *  
 *--------------------------------------------------------------------------*/
 
new function(){

	/*
	 *�C�x���g�ǉ��p
	  -------------------------------------------------*/
	function addEvent(elm,listener,fn){
		try{ // IE
			elm.addEventListener(listener,fn,false);
		}catch(e){
			elm.attachEvent(
				"on"+listener
				,function(){
					fn.apply(elm,arguments)
				}
			);
		}
	}

	/*
	 *�X���[�Y�X�N���[��
	  -------------------------------------------------*/
	function SmoothScroll(a){
		if(document.getElementById(a.rel.replace(/.*\#/,""))){
			var e = document.getElementById(a.rel.replace(/.*\#/,""));
		}else{
			return;
		}
		
		//�ړ��ʒu
		var end=e.offsetTop
		var docHeight = document.documentElement.scrollHeight;
		var winHeight = window.innerHeight || document.documentElement.clientHeight
		if(docHeight-winHeight<end){
			end = docHeight-winHeight;
		}


		//���݈ʒu
		var start=window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
		
		
		var flag=(end<start)?"up":"down";

		function scrollMe(start,end,flag) {
			setTimeout(
				function(){
					if(flag=="up" && start >= end){
						start=start-(start-end)/20-1;
						window.scrollTo(0,start)
						scrollMe(start,end,flag);
					}else if(flag=="down" && start <= end){
						start=start+(end-start)/20+1;
						window.scrollTo(0,start)
						scrollMe(start,end,flag);
					}else{
						scrollTo(0,end);
					}
					return ;
				}
				,10
			);
			
		}

		scrollMe(start,end,flag)
		
	}

	/*
	 *�X���[�Y�ϊ��X�N���v�g
	  -------------------------------------------------*/
	addEvent(window,"load",function(){
		var anchors = document.getElementsByTagName("a");
		for(var i = 0 ; i<anchors.length ; i++){
			if(anchors[i].href.replace(/\#[a-zA-Z0-9]+/,"") == location.href.replace(/\#[a-zA-Z0-9]+/,"")){
				anchors[i].rel = anchors[i].href;
				anchors[i].href = "javascript:void(0)";
				anchors[i].onclick=function(){SmoothScroll(this)}
			}
		}
	});

}