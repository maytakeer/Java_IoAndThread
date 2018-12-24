Ext.define('Ushine.UserGrid', {
	extend: 'Ext.grid.Panel',
	initComponent: function(){
		this.addEvents('edit-user');
		this.callParent();
		this.mon(this, 'edit-user', this.editUser, this);
	},
	store: Ext.create('Ext.data.Store', {
        model: Ext.define('Image', {
            extend: 'Ext.data.Model',
            fields: [
                { name:'src', type:'string' },
                { name:'name', type:'string' },
                { name:'url', type:'string' }
            ]
        }),
        data: [
            { src:'images/1.jpg', name:'Drawing & Charts',url: 'Ext.panel.Panel' },
            { src:'images/2.jpg', name:'Advanced Data',url: 'Ushine.UserManager' },
            { src:'images/3.jpg', name:'Overhauled Theme',url: 'Ext.panel.Panel' },
            { src:'images/4.jpg', name:'Performance Tuned',url: 'Ext.panel.Panel' },
            { src:'images/5.jpg', name:'Overhauled Theme',url: 'Ext.panel.Panel' }
        ]
    }),
    columns: [
              { text: '名称',  dataIndex: 'name' },
              { text: '图片路径', dataIndex: 'src', flex: 1 },
              { text: '控件', dataIndex: 'url' }
          ],
    tbar: Ext.create('Ext.toolbar.Toolbar',{
    	height: 30,
    	items: [{
    		xtype: 'button',
    		text: '添加用户',
    		handler: function(){
    			this.ownerCt.ownerCt.fireEvent('edit-user');
    		}
    	},{
    		xtype: 'textfield', 
    		fieldLabel: '用户名'
    	}]
    }),
    editUser: function(user){
    	var win = Ext.create('Ext.window.Window', {
    		title: '编辑用户',
    		width: 300,
    		height: 200,
    		items: {
    			xtype: 'form',
    			defaults: {
    				labelWidth: 70,
    				xtype: 'textfield'
    			},
    			items: [{
    				name: 'name',
    				fieldLabel: '名称',
    				value: user?user.get('name'):''
    			}],
    			buttons: [{
    				text: '确定',
    				handler: function(){
    					win.getComponent(0).getForm().submit({
    						url: 'addUser.jsp',
    						success: function(form, action) {
    							console.log(action.result.datas);
    							Ext.each(action.result.datas, function(item){
    								console.log(item.name+"\t"+item.id);
    							});
						       Ext.Msg.alert('Success', action.result.msg);
						    },
						    failure: function(form, action) {
						        switch (action.failureType) {
						            case Ext.form.action.Action.CLIENT_INVALID:
						                Ext.Msg.alert('Failure', 'Form fields may not be submitted with invalid values');
						                break;
						            case Ext.form.action.Action.CONNECT_FAILURE:
						                Ext.Msg.alert('Failure', 'Ajax communication failed');
						                break;
						            case Ext.form.action.Action.SERVER_INVALID:
						               Ext.Msg.alert('Failure', action.result.msg);
						       }
						    }
    					});
    					Ext.Ajax.request({
    						url: 'addUser.jsp',
    						success: function(response, opts) {
    							console.log(response);
    					        var obj = Ext.decode(response.responseText);
    					        console.dir(obj);
    					    },
    					    failure: function(response, opts) {
    					        console.log('server-side failure with status code ' + response.status);
    					    }
    					});
    				}
    			},{
    				text: '取消',
    				handler: function(){
    					win.close();
    				}
    			}]
    		}
    	});
    	
    	win.show();
    }
});