Ext.onReady(function(){
	Ext.getDoc().on("contextmenu", function(e){
	    e.stopEvent();
	});
	var viewport = Ext.create('Ext.container.Viewport', {
		layout: 'border',
		defaults: {
			border: false
		},
		listeners: {
			afterrender: function(){
				this.on('menu-item-select', this.menuItemSelect, this);
			}
		},
		items: [{
			region: 'north',
			height: 72,
			bodyStyle: 'background: green',
			tpl: new Ext.XTemplate(
				'<div style="background:url(images/top-bg.png); height: 100%;">',
				'<div class="logo" style="margin-left:20px;width:63px; height:72px; background:url(images/logo.png);"></div>',
				'<div style=""></div>',
				'</div>'
			),
			listeners: {
				afterrender: function(){
					console.log('aaaaaaaaaaaaa');
					this.tpl.overwrite(this.body, null);
					this.body.on('click', function(e, t, eOpts ){
						if(t.className.indexOf('logo')!=-1){
							var win = Ext.create('Ext.window.Window', {
							    title: 'Hello',
							    height: 200,
							    width: 400,
							    layout: 'fit',
							    items: {  // Let's put an empty grid in just to illustrate fit layout
							        xtype: 'grid',
							        border: false,
							        columns: [{header: 'World'}],                 // One header just for show. There's no data,
							        store: Ext.create('Ext.data.ArrayStore', {}) // A dummy empty data store
							    }
							});
							win.show();
						}
					}, this);
				}
			}
		},{
			region: 'south',
			height: 40,
			bodyStyle: 'background: red'
		},{
			region: 'west',
			width: 250,
//			bodyStyle: 'background: blue',
			items: Ext.create('Ext.view.View', {
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
			    tpl: new Ext.XTemplate(
			    	    '<tpl for=".">',
			            '<div style="width:200px;height:225px; text-align: center;" class="thumb-wrap">',
			              '<div class="image" style="background:url({src});width: 130px; height: 130px; margin: 20px auto;"></div>',
			              '<div class="shadow" style="background:url(images/shadow.png);background-position:0 0; width:170px; height: 20px; margin: 0 auto; position: relative; top: -35px;"></div>',
			              '<div class="name" style="color: #999;">{name}</div>',
			            '</div>',
			        '</tpl>'
			    ),
			    itemSelector: 'div.thumb-wrap',
			    emptyText: 'No images available',
			    listeners: {
			    	itemclick: function(thiz, record, item, index, e, eOpts){
			    		viewport.fireEvent('menu-item-select', record);
			    	},
			    	itemmouseenter: function(thiz, record, item, index, e, eOpts){
			    		console.log(item);
//			    		item.style="background: red;";
			    	},
			    	itemcontextmenu: function(thiz, record, item, index, e, eOpts){
			    		console.log('bbbbbbbbbbbb');
			    	}
			    }
			})
		},{
			region: 'center',
			itemId: 'center',
			layout: 'fit'
			
		}],
		menuItemSelect: function(record){
			var center = this.getComponent('center');
    		center.removeAll(true,true);
    		var panel = Ext.create(record.get('url'), {
    			title: record.get('name'),
    			layout: 'fit',
    		});
    		center.add(panel);
		}
	});
	
});