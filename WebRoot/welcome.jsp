<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>

<title>某雄联盟</title>
<script type="text/javascript"
	src="<%=path%>/statics/js/jquery-1.12.4.js"></script>
	<style>
		body, dl, dd, ul, ol, h1, h2, h3, h4, h5, h6, p, form { margin: 0; }
		body, button, input, select, textarea { font: 12px/1.5 tahoma,'\5FAE\8F6F\96C5\9ED1',sans-serif; }
		h1, h2, h3, h4, h5, h6 { font-size: 100%; }
		em, b { font-style: normal; }
		a { text-decoration: none; }
		a:hover { text-decoration: underline; }
		img { border: 0; }
		button, input, select, textarea { font-size: 100%; outline: none; }
		table { border-collapse: collapse; border-spacing: 0; }
		td, th, ul, ol { padding: 0; }
		ul, ol, dl { list-style: none; }
		.clearfix:after { visibility: hidden; display: block; font-size: 0; content: " "; clear: both; height: 0; }
		.clearfix { *zoom: 1; }
		/*通用底部样式*/
		#afooter { background: #000000; text-align: center; position: relative; z-index: 10; }
		#afooter .wrap_ieg { width: 1240px; margin: 0 auto; padding: 30px 0; }
		#afooter p { color: #6e6e6e; line-height: 24px; font-size: 10px; }
		#afooter a { color: #6e6e6e; font-size: 12px; }
		.fl { float: left; }
		.fr { float: right; }
		.chromeframe { display: none !important; }
		.comm-head { position: relative !important; background: #000000; }
		.comm-topact { display: none; }
		html, body { background: #000; }
		.g-wrap { position: relative; width: 100%; max-width: 1920px; min-width: 1240px; overflow: hidden; height: 990px; margin: 0 auto; }
			
		/*自定义样式 开始*/
	
		.hid{text-indent:-9999px;font-size:0px;overflow:hidden;width:0px;height:0px;display:block}
		.bg{position:relative;min-width:1000px;overflow:hidden;}
		.bg{ background:url(/HeroWeb/statics/images/bg.jpg) no-repeat 50% 0;}
		.bgc{ background: url(/HeroWeb/statics/images/bgc.jpg) no-repeat;  width:1000px; height:990px; margin: 0 auto;position: relative;}
		.topVideo {width: 1920px;height: 990px;display: block;position: absolute;top: 0;left: 50%;margin-left: -960px;pointer-events: none;overflow: hidden;}
		
		.video-pic{z-index: 2;outline:none;position: absolute;top: 420px;left: 50%;width: 107px;height: 111px;margin-left:-54px;background: url(/HeroWeb/statics/images/banner-video.png) no-repeat;-webkit-animation: fadeInUp .8s .5s both;-moz-animation: fadeInUp .8s .5s both;-ms-animation: fadeInUp .8s .5s both;-o-animation: fadeInUp .8s .5s both;animation: fadeInUp .8s .5s both;}
		.btn-div{width: 756px; height: 120px;margin: 758px auto 0; z-index: 5;text-align: center;-webkit-animation: fadeInUp .8s .8s both;-moz-animation: fadeInUp .8s .8s both;-ms-animation: fadeInUp .8s .8s both;-o-animation: fadeInUp .8s .8s both;animation: fadeInUp .8s .8s both;}
		.btn-div a{width: 238px;height: 120px;float: left;background:url(/HeroWeb/statics/images/btn.png) no-repeat;transition: all 0.3s;}
		.btn-div a:hover{background:url(/HeroWeb/statics/images/btn.png) no-repeat;transform: translateY(-10px);}
		.btn-div a.btn-1{background-position: 0 0;margin-right: 18px;}
		.btn-div a.btn-2{background-position: -257px 0;margin-right: 23px;}
		.btn-div a.btn-3{background-position: -518px 0;}
		
	   @keyframes fadeInUp {
		    from { opacity: 0; -webkit-transform:translateY(15px);-ms-transform:translateY(15px);-o-transform:translateY(15px);transform:translateY(15px);}
		    to { opacity: 1; transform: none; }
		}
		@-webkit-keyframes  fadeInUp {
		    from { opacity: 0; -webkit-transform:translateY(15px);-ms-transform:translateY(15px);-o-transform:translateY(15px);transform:translateY(15px);}
		    to { opacity: 1; transform: none; }
		}
		@-moz-keyframes fadeInUp {
		    from { opacity: 0; -webkit-transform:translateY(15px);-ms-transform:translateY(15px);-o-transform:translateY(15px);transform:translateY(15px);}
		    to { opacity: 1; transform: none; }
		}
		@-ms-keyframes fadeInUp {
		    from { opacity: 0; -webkit-transform:translateY(15px);-ms-transform:translateY(15px);-o-transform:translateY(15px);transform:translateY(15px);}
		    to { opacity: 1; transform: none; }
		}
		@-o-keyframes  fadeInUp {
		    from { opacity: 0; -webkit-transform:translateY(15px);-ms-transform:translateY(15px);-o-transform:translateY(15px);transform:translateY(15px);}
		    to { opacity: 1; transform: none; }
		}
		
    /*弹窗*/
    .pop{background: #000000;}
    .pop .dia-close{color: #89cbff;font-size:58px;position: absolute;top: -23px;right: -54px;font-weight: lighter;}
    .dia-close:hover{
    text-decoration: underline;
    }
    .videopop{width: 1280px; height: 720px; position: relative;}
		.videopop #container{width: 100%;height: 100%;}
    /*自定义样式 结束*/

  </style>
</head>

<body>
	<%@include file="/common/header.jsp"%>
	<div class="g-wrap">
		<!--自定义HTML内容 开始 -->

		<div class="bg">
			<div class="bgc">
				<h1 class="hid">2018冰雪节</h1>
				
				<div class="title"></div>
				<div class="topVideo">
					<video class="topVid" autoplay="autoplay" loop="loop" muted="muted"
						src="<%=path%>/statics/viedo/video.mp4"></video>
				</div>
				<a href="javascript:;" class="video-pic"></a>
				<div class="btn-div">
				
					<a href="<%=path %>/pre/website.jsp"
						class="btn-1" title="进入官网"
						onclick="pgvSendClick({hottag:'index.snow.btn.inlol'});"></a> <a
						href="//lol.qq.com/act/a20181207snow/index.html?ADTAG=lolweb.v3.index"
						class="btn-2" target="_blank" title="查看详情"
						onclick="nyo()"></a> <a
						href="javascript:;" onclick="nyo()"
						class="btn-3" title="下载游戏"
						onclick="pgvSendClick({hottag:'index.snow.btn.indownload'});"></a>
				</div>
			</div>
		</div>
		<!--自定义HTML内容 结束-->
	</div>
	<div class="pop videopop" id="pop1" style="display: none;">
		<a href="javascript:showDialog.hide();" class="dia-close" >X</a>
		<div id="container"></div>
	</div>

	<script type="text/javascript" src="//ossweb-img.qq.com/images/js/milo_bundle/milo.js"></script>
	<script type="text/javascript" src="//vm.gtimg.cn/tencentvideo/txp/js/txplayer.js"></script>
	<script type="text/javascript" src="<%=path%>/statics/js/showDialog.min.js"></script>
	<script>
		// 播放视频
		function showVideoDia(vid) {
			var player = new Txplayer({
				containerId : 'container',
				vid : vid,
				width : '1280',
				height : '720',
				autoplay : true
			});
			TGDialogS('pop1');
		};

		$('.dia-close').click(function() {
			$('#container').html('');
		});

		//点击视频停止bgm
		$('.video-pic').click(function() {
			showVideoDia('b0809hhah6b');
		});

		function TGDialogS(e) {
			// 利用milo库引入dialog组件
			need("biz.dialog", function(Dialog) {
				Dialog.show({
					id : e,
					bgcolor : '#000', //弹出“遮罩”的颜色，格式为"#FF6600"，可修改，默认为"#fff"
					opacity : 50
				//弹出“遮罩”的透明度，格式为｛10-100｝，可选
				});
			});
		};

		function closeDialog() {
			// 利用milo库引入dialog组件
			need("biz.dialog", function(Dialog) {
				Dialog.hide();
			});
		};
		function nyo(){
			alert("暂未开放!");
			return false;
		}
	</script>
	<%@include file="common/footer.jsp"%>
</body>
</html>
