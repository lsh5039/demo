
var main = {
    init : function(){
        var _this = this;

        $('#btnSave').click(function(){

            _this.save();
        });

        $('#btn-update').on('click',function (){
            _this.update();
        })

        $('#btn-delete').on('click',function (){
            _this.delete();
        })



    },

    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type : 'post',
            url : '/api/v1/posts', 
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data),
            success : function (){
                alert('글 등록에 성공했습니다.');
                window.location.href= '/';
            },
            error : function(){
                alert('에러발생');
            console.log("ajax error");
        }})


    },

    update : function(){
        var data = {
            title : $('#title').val(),
            content : $('#content').val()
        };
        var id = $('#id').val();

        $.ajax({
            type : 'put',
            url : '/api/v1/posts/'+id,
            dataType: 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function (){
            alert('글이 수정되었습니다.');
            window.location.href='/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },

    delete: function (){
        var id = $('#id').val();

        $.ajax({
            type : 'delete',
            url : '/api/v1/posts/'+id,
            dataType: 'json',
            contentType : 'application/json; charset=utf-8',
        }).done(function (data){
            alert(data+'번 글을 삭제했습니다.');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        })


    }

    };

    main.init();