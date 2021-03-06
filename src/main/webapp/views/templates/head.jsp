<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>IssueTracker</title>

    <link rel="stylesheet" href="../../resources/css/style.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
</head>
<body>
    <div class="container content">
        <header>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand">IssueTracker</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="/users?command=GET_USERS">Users</a></li>
                            <li><a href="/projects?command=GET_PROJECTS">Projects</a></li>
                            <li><a href="/sprints?command=GET_SPRINTS">Sprints</a></li>
                            <li><a href="/tasks?command=GET_TASKS">Tasks</a></li>
                            <li><a href="/comments?command=GET_COMMENTS">Comments</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>