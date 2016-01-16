Backbone.Model.prototype.idAttribute = '_id';

// Backbone Model

var Blog = Backbone.Model.extend({
	defaults: {
		author: '',
		title: '',
		url: ''
	}
});

// Backbone Collection

// instantiate two Blogs

var blog1 = new Blog({
	author: 'Priyanku',
	title: 'Blog',
	url: 'web address'
});

var blog2 = new Blog({
	author: 'Author',
	title: 'Luther',
	url: 'url'
});

var updateBlog;
var Blogs = Backbone.Collection.extend({});

// instantiate a Collection

var blogs = new Blogs([blog1,blog2]);

// Backbone View for one blog

var BlogView = Backbone.View.extend({
	model: new Blog(),
	tagName: 'tr',
	initialize: function() {
		this.template = Handlebars.compile( $(".blogs-list-template").html() );
	},
	events: {
		'click .edit-blog': 'edit',
		'click .cancel': 'cancel',
		'click .update-blog': 'update',
		'click .delete-blog': 'deleteBlog',
	},
	edit: function() {
		$('.edit-blog').hide();
		$('.delete-blog').hide();
		this.$('.update-blog').show();
		this.$('.cancel').show();
		updateBlog = new Blog({
			author: this.$('.author').html(),
			title: this.$('.title').html(),
			url: this.$('.url').html()
		});

		this.$('.author').html('<input type="text" class="form-control author-update" value="' + updateBlog.get('author') + '">');
		this.$('.title').html('<input type="text" class="form-control title-update" value="' + updateBlog.get('title') + '">');
		this.$('.url').html('<input type="text" class="form-control url-update" value="' + updateBlog.get('url') + '">');
	},
	cancel: function() {
		blogsView.render();
	},
	update: function(){
		this.model.set('author', $('.form-control.author-update').val());
		this.model.set('title', $('.form-control.title-update').val());
		this.model.set('url', $('.form-control.url-update').val());
	},
	deleteBlog: function(){
		this.model.destroy();
	},
	render: function() {
		this.$el.html(this.template(this.model.toJSON()));
		return this;
	}
});

// Backbone View for all blogs

var BlogsView = Backbone.View.extend({
	model: blogs,
	el: $('.blogs-list'),
	initialize: function() {
		var self = this;
		this.model.on('add', this.render, this);
		this.model.on('remove', this.render, this);
		this.model.on('change', this.renderTimeOut, this);
	},
	/**
	 * for rendering after all three variables have been changed
	 */
	renderTimeOut: function(){
		var self = this;

		setTimeout(function(){
			self.render();
		}, 100);
	},
	render: function() {
		var self = this;
		this.$el.html('');
		_.each(this.model.toArray(), function(blog) {
			self.$el.append((new BlogView({model: blog})).render().$el);
		});
		return this;
	}
});

var blogsView = new BlogsView();

$(document).ready(function() {
	$('.add-blog').on('click', function() {
		var blog = new Blog({
			author: $('.author-input').val(),
			title: $('.title-input').val(),
			url: $('.url-input').val()
		});
		$('.author-input').val('');
		$('.title-input').val('');
		$('.url-input').val('');
		blogs.add(blog);
	});
	
})
