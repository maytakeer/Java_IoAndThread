Ext.define('Ushine.UserManager', {
	extend: 'Ext.panel.Panel',
	constructor: function(config){
		this.addEvents('load-data');
		this.config = config;
		this.callParent([config]);
		this.mon(this, 'load-data', this.loadData, this);
	},
	listeners: {
		afterrender: function(){
			this.fireEvent('load-data');
			console.log('afterrender...'+this.getHeight());
		},
		afterlayout: function(){
			console.log('layout...'+this.getHeight());
		}
	},
	loadData: function(){
		var userGrid = Ext.create('Ushine.UserGrid', {
			
		});
		this.add(userGrid);
	}
});