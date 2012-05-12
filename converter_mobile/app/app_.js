var server = 'localhost';
var port = '8080';
var dateMaJ ='';
var mode = true; // true = mode online
//var isMatriceConversionsUpdated = 0; // variable pour tester si la matrice de conversions est remplie
//localStorage.setItem("isMatriceConversionsUpdated",1);

var CurrencyModel = new Ext.regModel('Currencies', {
    fields: [
		{name:'code', type: 'string'},
		{name:'curr_name', type: 'string'},
		{name:'flag_url', type: 'string'}
	]
});

var listeCurrency = new Ext.data.JsonStore({
data : [
	{code : 'USD', curr_name : 'United States Dollar', flag_url: ''},
	{code : 'EUR', curr_name : 'Euro', flag_url: ''},
	{code : 'GBP', curr_name : 'British Pound Sterling', flag_url: ''},
	{code : 'JPY', curr_name : 'Japanese Yen', flag_url: ''},
	{code : 'CHF', curr_name : 'Swiss Franc', flag_url: ''},
	{code : 'CAD', curr_name : 'Canadian Dollar', flag_url: ''},
	{code : 'AUD', curr_name : 'Australian Dollar', flag_url: ''},
	{code : 'MXN', curr_name : 'Mexican Peso', flag_url: ''},
	{code : 'TND', curr_name : 'Tunisian Dinar', flag_url: ''},
	{code : 'AZN', curr_name : 'Afghan Afghani', flag_url: ''},
],
model : 'Currencies',
autoLoad : true,
autoDestroy : true
});


/******************************************************************************************
*
* Liste de conversions prédéfinie
*
*******************************************************************************************/

Ext.regModel('StockQuote', {
    fields: [
            {name: 'stock_name', type: 'string'},
            {name: 'stock_code', type: 'string'},
			{name: 'ask', type: 'string'},
			{name: 'change', type: 'string'},
			{name: 'change_percent', type: 'string'},
			{name: 'icon', type: 'string'},
			{name: 'arrowUrl', type: 'string'}  			
    ]
});


var conversionStore = new Ext.data.Store({
    model : 'StockQuote',
    /*sorters: [
         {property: 'stock_name', direction: 'ASC'}
    ],*/
    
    data: [
        {stock_name: 'Apple Inc.',   stock_code: 'AAPL', ask: '', icon: 'app/logos/apple32.png', arrowUrl: 'app/logos/transparent.png'},
        {stock_name: 'Google Inc.',     stock_code: 'GOOG', ask: '', icon: 'app/logos/google32.png', arrowUrl: 'app/logos/transparent.png'},
        {stock_name: 'Microsoft Corporation',      stock_code: 'MSFT', ask: '', icon: 'app/logos/msft.png', arrowUrl: 'app/logos/transparent.png'},
        {stock_name: 'Yahoo! Inc.',   stock_code: 'YHOO', ask: '', icon: 'app/logos/yahoo32.png', arrowUrl: 'app/logos/transparent.png'},
        {stock_name: 'Oracle Corporation',   stock_code: 'ORCL', ask: '', icon: 'app/logos/oracle.png', arrowUrl: 'app/logos/transparent.png'},
        {stock_name: 'Cisco Systems, Inc.',    stock_code: 'CSCO', ask: '', icon: 'app/logos/cisco.png', arrowUrl: 'app/logos/transparent.png'},
        {stock_name: 'Intel Corporation', stock_code: 'INTC', ask: '', icon: 'app/logos/intel32.png', arrowUrl: 'app/logos/transparent.png'},
        {stock_name: 'Alcatel-Lucent, S.A.', stock_code: 'ALU', ask: '', icon: 'app/logos/alu32.png', arrowUrl: 'app/logos/transparent.png'}
    ],
    autoLoad : true
});



var list = new Ext.List({
        id: 'conversionList',
        store: conversionStore,
        itemTpl:
		  '<div id="liste-bloc1">'+		
          '<div class="list-item-title">{stock_name} ({stock_code})</div>'+
		  '<img src="{icon}" />'+
          '<div class="list-item-narrative"><b>{ask}</b>&nbsp; {change} &nbsp;{change_percent}</div> '+
		  '</div>'+
		  '<div id="arrow"><img  src={arrowUrl} /></div>'		  
        ,
		indexBar: false,		
        centered: true,    
        modal: true,
        fullscreen: true	
});


/*
* modèle de données pour le stockage des stock quotes (cours des actions)
*/

Ext.regModel("StockQ", {
    fields:[
		{name: 'stock_name', type:'string'},
		{name: 'stock_code', type:'string'},
		{name: 'ask', type: 'string'},
		{name: 'change', type: 'string'},
		{name: 'change_percent', type: 'string'}
	],    
});

var matriceStockQuotes = new Ext.data.JsonPStore({
    model: 'StockQ',
	storeId: 'matriceStockQuotesId',
	root: 'stockquotes',
	proxy: new Ext.data.LocalStorageProxy ({
		id: 'matriceStockQuotesId'
	})	
});

/*
* modèle de données pour le stockage des conversions(cours de la devise)
*/

Ext.regModel("Currency", {
    fields:[
		{name: 'curr_code', type:'string'},
		{name: 'curr_name', type:'string'}
	],
    hasMany: {model: 'toCurrencyItem', name: 'liste_conv'}
});


Ext.regModel("toCurrencyItem", {
    fields: [
        {name:'USD', type:'string'},
        {name:'EUR', type:'string'},
        {name:'GBP', type:'string'},
        {name:'JPY', type:'string'},
        {name:'CHF', type:'string'},
        {name:'CAD', type:'string'},
        {name:'AUD', type:'string'},
		{name:'MXN', type:'string'},
        {name:'TND', type:'string'}
     ],
     belongsTo: 'Currency'
     
});



/*************************************************************************************
 *
 *  Matrice des conversions (toutes les combinaisons entre les devises)
 *
 ************************************************************************************/

var matriceConversions = new Ext.data.JsonPStore({
    model: 'Currency',
	storeId: 'matriceConversionsid',
	root: 'conversions',
    /*getGroupString: function(instance) {
        return instance.get('curr_code')[0];
    }*/
});


/*
* Offline matriceConversions(localstorage)
*/

var offlineMatriceConversions = new Ext.data.JsonPStore({
    model: 'Currency',
	proxy: new Ext.data.LocalStorageProxy ({
		id: 'offlineMatriceConversionsId'
	}),	
});

/*
 * Interface des actions
 * 
 */

mesActions = new Ext.Panel({
    id: 'mes_actions',
    fullscreen: true,
	defaults:{
		border: false
	},
    layout: 'card',
	items: [list]

});

/*
 * Interface des indices principaux
 * 
 */

indices = new Ext.Panel({
    id: 'indices_principaux',
    layout: 'fit',
    html: 'Indices principaux'
});


/*
 * Bottom toolBar
 */

var bottomToolbar = new Ext.Toolbar({
	id: 'bottomToolBarId',
    dock: 'bottom',
    items: [
		{ iconMask: true,ui: 'action-round', iconCls: 'info', handler: infoAppli },
		{ iconCls: 'settings', title: 'Settings', iconMask: true, handler: config },
        {xtype: 'spacer'},
        {
            iconCls: 'refresh',
            iconMask: true,
            handler: function (){
				if(tabs.getActiveItem().getItemId() == 'form_convertisseur'){
					miseAjourStorage();
				}else{
					miseAjourStockQuotes();
				}
			}
        }
    ]
});


/*
 * validation de la configuration
 */
function valider_config(){
	if(Ext.getCmp('server').getValue()!='' && Ext.getCmp('port').getValue()!=''){
		server = Ext.getCmp('server').getValue();
		port = Ext.getCmp('port').getValue();
	}
	Ext.getCmp('configpopup').hide();
	//console.log('server= '+server+' port= '+port);
}




/*
 * popup de configuration
 */
 
function config(server,port){
	//Ext.Msg.prompt("Settings","Server",Ext.emptyFn);
	if (!this.popup) {
	this.popup = new Ext.Panel({
		floating: true,
		modal: true,
		centered: true,
		width: 300,
		height: 250,
		id: 'configpopup',
		styleHtmlContent: true,
		scroll: 'vertical',
		//html: '',
		dockedItems: [{
			dock: 'top',
			xtype: 'toolbar',
			title: 'Configuration'
		},
		{
			dock: 'bottom',
			xtype: 'toolbar',
			items:[ 
				{iconMask: true, ui: 'confirm-round', iconCls: 'compose', handler: valider_config},
                {iconMask: true, ui: 'decline', iconCls: 'delete', handler: function(){Ext.getCmp('configpopup').hide();}},
			]
		}],					
		items: [{
			xtype: 'textfield',
			name: 'server',
			id: 'server',
			label: 'Server',
			placeHolder: 'localhost'
		},
		{
			xtype: 'numberfield',
			name: 'port',
			id: 'port',
			label: 'Port',
			placeHolder: '8080'
		},
		]
	});
	}
	this.popup.show('pop');
} //fin popup de configuration

function timeout_req(){
	var erreur = Ext.util.JSONP.callback({'error':'timeout'});
	console.log("Switch to offline mode");
	localStorage.setItem("isMatriceConversionsUpdated",1);
	return erreur;
}

/*
 * fonction de récupération de la mise à jour
 */
 
function miseAjourStorage(){
	var alertTimerId = window.setTimeout("timeout_req()", 10000); 
	var loadingMask = new Ext.LoadMask(Ext.getBody(), {
                msg: "Update de la base locale..."
	});
	loadingMask.show(); // afficher un masqie pendant la MaJ 
	Ext.util.JSONP.request({
		url: 'http://'+server+':'+port+'/CurrencyConverterWSServlet/CurrencyConverterServlet',
		//url: '//localhost/Local_D/converter_client/app/test_conversions.json',
		/* paramètres de la requete mais c'était juste pour les tests, la version actuelle récupère la MaJ des conversions
		* pour toutes les devises pas uniquement pour une devise entrée par l'utilisateur
		*/	
		params: { 
			curr_from: Ext.getCmp('curr_from').value,
			curr_to: Ext.getCmp('curr_to').value,			
		},
		scope: this,
		callbackKey: 'callback', // callbackKey indique le paramètre GET qui sera envoyé au serveur contenant le nom fonction à exécuter lorsque la requete se termine
		callback: function(result) { // fonction de rappel qui s'execute dès que la réponse du serveur arrive
			if (result.error) { // si il y a des erreurs dans la réponse 
				Ext.getBody().unmask(); // enlever le masque
				Ext.Msg.alert('Erreur de update ',result.error);				
			}
			else { // si pas d'erreurs
				Ext.getBody().unmask(); // enlever le masque
				//isMatriceConversionsUpdated = 1;
				localStorage.setItem("isMatriceConversionsUpdated",1);
				var currentDate = new Date();
				Ext.Msg.alert('Succès de update ', currentDate.format('l j F, Y, G:i'));
				dateMaJ = currentDate.format('l j F, Y, G:i');
				//Ext.getCmp('bottomToolBarId');				

				
				
				
				// l   A full textual representation of the day of the week Sunday to Saturday
				// j   Day of the month without leading zeros  1 to 31
				// F   A full textual representation of a month,such as January or March January to December
				// Y   A full numeric representation of a year, 4 digits Examples: 1999 or 2003
				// G   24-hour format of an hour without leading zeros 0 to 23
				// i   Minutes, with leading zeros 00 to 59
				
				matriceConversions.loadRecords(result) ; // remplir la matrice de conversions
				console.log(matriceConversions);
				offlineMatriceConversions.loadRecords(result);
				localStorage.setItem('offlineMatriceConversionsId', JSON.stringify(result));
				//console.log(JSON.stringify(result));
				
				
				/*console.log('Localstorage:\n');
				for (key in localStorage){
					console.log(key, localStorage[key]);
				}*/
				
			    var index=0;								
				while (matriceConversions.data.map.conversions[index].curr_code != Ext.getCmp('curr_from').value){									
					index++;
					console.log(index);
				}
				
				var from = Ext.getCmp('curr_from').value;
				var to = Ext.getCmp('curr_to').value;
				var resultat_conv = (matriceConversions.data.map.conversions[index].liste_conv[0])[to];
				console.log('From: '+from+' to '+to+' = '+resultat_conv);
				  // mise à jour du champ du resultat de la conversion
				  Ext.getCmp('form_convertisseur').setValues({
						resultfield: resultat_conv

				  });
			}															
		}
	});
	
}//fonction de récupération de la mise à jour


function miseAjourStockQuotes(){
	if (localStorage["matriceStockQuotesId"] == ""){
		var loadingMask = new Ext.LoadMask(Ext.getBody(), {
					msg: "Update de la base locale..."
		});
		
		loadingMask.show();

		Ext.util.JSONP.request({
		
			url: 'http://'+server+':'+port+'/CurrencyConverterWSServlet/StockQuotesServlet',
			//url: '//localhost/Local_D/converter_client/app/test_conversions.json',
			callbackKey: 'callback', // callbackKey indique le paramètre GET qui sera envoyé au serveur contenant le nom fonction à exécuter lorsque la requete se termine
			callback: function(result) {
				if (result.error) { // si il y a des erreurs dans la réponse 
					Ext.getBody().unmask(); // enlever le masque
					Ext.Msg.alert('Erreur de update ',result.error);				
				}
				else { // si pas d'erreurs
					Ext.getBody().unmask(); // enlever le masque
					var currentDate = new Date();
					Ext.Msg.alert('Succès de update ', currentDate.format('l j F, Y, G:i'));
					
					matriceStockQuotes.loadRecords(result) ; // remplir la matrice des actions (matriceStockQuotes)
					localStorage.setItem('matriceStockQuotesId', JSON.stringify(result));
					console.log(JSON.stringify(result));
					
					//console.log(matriceStockQuotes);
					var el = Ext.get('arrow');
					el.select('arrow', true);
					el.show();
					
					for (var i=0;i<8;i++){
						conversionStore.getAt(i).set('ask',matriceStockQuotes.data.map.stockquotes[i].Ask);
						conversionStore.getAt(i).set('change',matriceStockQuotes.data.map.stockquotes[i].Change);
						conversionStore.getAt(i).set('change_percent',matriceStockQuotes.data.map.stockquotes[i].ChangeInPercent);
						conversionStore.getAt(i).set('arrowUrl',matriceStockQuotes.data.map.stockquotes[i].arrowUrl);				
					}
	
					//Ext.getCmp('conversionList').refresh();
							
				}
			
			
			} 
		
		
		
		});
	}
	else{
		matriceStockQuotes = JSON.parse(localStorage["matriceStockQuotesId"]) ;
		for (var i=0;i<8;i++){
			conversionStore.getAt(i).set('ask',matriceStockQuotes.stockquotes[i].Ask);
			conversionStore.getAt(i).set('change',matriceStockQuotes.stockquotes[i].Change);
			conversionStore.getAt(i).set('change_percent',matriceStockQuotes.stockquotes[i].ChangeInPercent);
			conversionStore.getAt(i).set('arrowUrl',matriceStockQuotes.stockquotes[i].arrowUrl);				
		}
	}
//console.log('miseAjourStockQuotes appelée!');
}//fonction de récupération de la mise à jour des stockquotes


/*
 * fonction de mise à jour des champs
 */
 
function convertir(){
	
	var to = Ext.getCmp('curr_to').value;
	var from = Ext.getCmp('curr_from').value;
	var qty = Ext.getCmp('amount').getValue(); // pour les champs de type numberfield, on utiise la methode getValue()
	var resultat_conv = 0;
	var res_toEUR = 0
	var res_toUSD = 0
	var res_toJPY = 0
	var res_toGBP = 0
	var res_toCHF = 0
	var res_toCAD = 0
	var res_toAUD = 0
	var res_toTND = 0
							
	if ((to == from) && localStorage["offlineMatriceConversionsId"] == "" /*(localStorage.getItem("isMatriceConversionsUpdated")  != 1)*/){
		resultat_conv = qty;
		Ext.getCmp('form_convertisseur').setValues({
			curr_toEUR: '',
			curr_toUSD: '',
			curr_toJPY: '',
			curr_toGBP: '',
			curr_toCHF: '',
			curr_toCAD: '',
			curr_toAUD: '',
			curr_toTND: ''
		});
		Ext.Msg.alert('Base locale vide!','Il faut se connecter à internet et mettre à jour la Base');								
																	
	}
	else{
		if (localStorage.getItem("isMatriceConversionsUpdated") != 1) {
			Ext.Msg.alert('Base locale vide!','Il faut se connecter à internet et mettre à jour la Base');
		}
		else{
			offlineMatriceConversions = JSON.parse(localStorage["offlineMatriceConversionsId"]) ;
			//console.log(offlineMatriceConversions);
			var index=0;								
			while (offlineMatriceConversions.conversions[index].curr_code != Ext.getCmp('curr_from').value){									
				index++;
				//console.log(index);
			}
															
			resultat_conv =(offlineMatriceConversions.conversions[index].liste_conv[0])[to]*qty;
			res_toEUR = (offlineMatriceConversions.conversions[index].liste_conv[0])['EUR']*qty;
			res_toUSD = (offlineMatriceConversions.conversions[index].liste_conv[0])['USD']*qty;
			res_toJPY = (offlineMatriceConversions.conversions[index].liste_conv[0])['JPY']*qty;
			res_toGBP = (offlineMatriceConversions.conversions[index].liste_conv[0])['GBP']*qty;
			res_toCHF = (offlineMatriceConversions.conversions[index].liste_conv[0])['CHF']*qty;
			res_toCAD = (offlineMatriceConversions.conversions[index].liste_conv[0])['CAD']*qty;
			res_toAUD = (offlineMatriceConversions.conversions[index].liste_conv[0])['AUD']*qty;
			res_toTND = (offlineMatriceConversions.conversions[index].liste_conv[0])['TND']*qty;
		}
		
	}
	
	//console.log('From: '+from+' to '+to+' = '+resultat_conv);
	 /* mise à jour du champ du resultat '=' et des champs des devises predefinies*/
	Ext.getCmp('form_convertisseur').setValues({
				resultfield: resultat_conv,
				curr_toEUR: res_toEUR,
				curr_toUSD: res_toUSD,
				curr_toJPY: res_toJPY,
				curr_toGBP: res_toGBP,
				curr_toCHF: res_toCHF,
				curr_toCAD: res_toCAD,
				curr_toAUD: res_toAUD,
				curr_toTND: res_toTND

	});							
}//fin fonction de mise à jour des champs

function infoAppli(){
	Ext.Msg.alert('TSE-Currency Converter','Developed by:<br> Arnaud CHEMLA<br>Mohamed Montassar CHERIF<br>Bilel GASMI<br>');
}

var formConverter = new Ext.form.FormPanel({
    scroll: 'vertical',
    title: 'Converter',
	xtype: 'form',
	id: 'form_convertisseur',
	
	items: [
		{
			xtype: 'selectfield',
			name: 'curr_from',
			id: 'curr_from',
			label: 'From',
			valueField : 'code',
			displayField : 'code',
			store: listeCurrency
		},
		{
			xtype: 'selectfield',
			name: 'curr_to',
			id: 'curr_to',
			label: 'To',
			valueField : 'code',
			displayField : 'code',
			store: listeCurrency
		},
		{
			xtype: 'numberfield',
			name: 'amount',
			id: 'amount',
			label:  'Amount ',
			value: 1,
			minValue: 1,
			placeHolder: 'Enter the amount of money'
		},
		{
			xtype: 'button',
			text: 'Convert',
			ui: 'confirm-round',
			handler: convertir
		},
		{
			xtype: 'textfield',
			name: 'resultfield',
			id: 'resultfield',
			label:  '= ',
			disabled: true
		},						
		{
			xtype: 'fieldset',
			title: 'Conversions'
		},
		{
			xtype: 'textfield',
			name: 'curr_toEUR',
			label: '<img src="app/flags/European-Union-Flag-24.png" />  EUR',
			height: '30px',
			id: 'curr_toEUR',
		
		},
		{
			xtype: 'textfield',
			name: 'curr_toUSD',
			label: '<img src="app/flags/United-States-Flag-24.png" />  USD',
			height: '30px',
			id: 'curr_toUSD',
		
		},
		{
			xtype: 'textfield',
			name: 'curr_toJPY',
			label: '<img src="app/flags/Japan-Flag-24.png" />  JPY',
			height: '30px',
			id: 'curr_toJPY',
		
		},
		{
			xtype: 'textfield',
			name: 'curr_toGBP',
			label: '<img src="app/flags/United-Kingdom-flag-24.png" /> GBP',
			height: '30px',
			id: 'curr_toGBP',
		
		},
		{
			xtype: 'textfield',
			name: 'curr_toCHF',
			label: '<img src="app/flags/Switzerland-Flag-24.png" /> CHF',
			height: '30px',
			id: 'curr_toCHF',
		
		},
		{
			xtype: 'textfield',
			name: 'curr_toCAD',
			label: '<img src="app/flags/Canada-Flag-24.png" /> CAD',
			height: '30px',
			id: 'curr_toCAD',
		
		},
		{
			xtype: 'textfield',
			name: 'curr_toAUD',
			label: '<img src="app/flags/Australia-Flag-24.png" /> AUD',
			height: '30px',
			id: 'curr_toAUD',
		
		},
		{
			xtype: 'textfield',
			name: 'curr_toTND',
			label: '<img src="app/flags/Tunisia-Flag-24.png" /> TND',
			height: '30px',
			id: 'curr_toTND',
		
		}
		]	
	});

var formActions = new Ext.form.FormPanel({
    scroll: 'vertical',
    title: 'Mes actions',
	id: 'form_actions',
    items: [
	{
		cls:'actions',
		title:'Mes Actions',
		//items: [mesActions]
		items: [mesActions]
	}]
});

/**********************************************************************************************************
 * Interface principale
 * 
 **********************************************************************************************************/
var tabs;
// initialisation de l'applcation
var converter_client = new Ext.Application({
	name: 'CurrencyConverter',
    launch: function() {
		/*console.log('Localstorage:\n');
		for (key in localStorage){
			console.log(key, localStorage[key]);
		}*/
        tabs = new Ext.TabPanel({
            fullscreen: true,
			scroll: 'vertical',
            dockedItems: [
			{
				xtype:'toolbar',
				title:'Currency Converter',
				//items: { iconMask: true,ui: 'action-round', iconCls: 'info', handler: infoAppli }
			},
			bottomToolbar
			],
            tabBar: {
                ui: 'light',
                layout: {
                    pack: 'center'
                }
            },
            items: [formConverter,formActions]
      
        });
		
		

    }
});
