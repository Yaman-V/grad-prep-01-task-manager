# grad-prep-01-task-manager

Phase 1 of our university capstone preparation. A full-stack task manager built to establish our core architecture, development workflow, and team collaboration practices.

## Project status

This project is an early draft created to practice development workflows and team collaboration. Core functionality and the UI are in place, but gaps, bugs, and planned features remain.

The main goal is learning—not delivering a production-ready application.

## Structure

This project has:

```text
grad-prep-01-task-manager/
├── frontend/
│   └── task-manager-frontend/  # React appli-cation
├── backend/
│   └── task-manager-backend/  # Spring Boot application
├── .gitignore
└── README.md
```

- `/frontend/task-manager-frontend` contains the React frontend.
- `/backend/task-manager-backend` contains the Spring Boot backend.
- Configuration files such as `.gitignore` and `.env.example` are kept in the project where needed.

> Do not commit secrets or sensitive information to `.env` files. Use `.env.example` to document required environment variables.

---

## Rules

1. The `main` branch is protected. No direct commits or force pushes are allowed.
2. All changes must go through a Pull Request (PR) and be reviewed before being merged into `main`.
3. We follow naming conventions for branches and commits.

### Commits

We use [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/).

Format:

```text
<type>[optional scope]: <description>
```

Examples:

```text
feat(task): add task creation
fix(auth): handle expired token
docs: update README
```

### Branches

Branch names should follow:

```text
<type>/<description>
```

Examples:

```text
feature/add-task
fix/task-validation
refactor/task-service
docs/update-readme
```

---

## How to build and run locally

### Prerequisites

- Java 25
- Node.js and npm
- A PostgreSQL database accessible to the backend

The backend's PostgreSQL connection must be configured with valid credentials before starting it. Keep credentials out of committed files.

### Backend

1. From the repository root, go to the backend project directory:

```powershell
cd backend\task-manager-backend
```

2. Build the Spring Boot project:

```powershell
.\mvnw.cmd clean package
```

3. Run the Spring Boot application:

```powershell
.\mvnw.cmd spring-boot:run
```

The backend starts at `http://localhost:8080`. Keep this terminal open while using the frontend.

### Frontend

1. Open a second terminal from the repository root and go to the frontend project directory:

```powershell
cd frontend\task-manager-frontend
```

2. Install the dependencies:

```powershell
npm ci
```

3. Start the Vite development server:

```powershell
npm run dev
```

Open the URL printed by Vite (by default, `http://localhost:5173`). The frontend expects the backend to be running at `http://localhost:8080`.

---

## Development Workflow

1. Create a new branch from `main`.
2. Make your changes and commit them using the commit convention.
3. Push your branch.
4. Open a Pull Request.
5. Get the changes reviewed.
6. Merge into `main` after approval.
