# Build Stage
FROM node:18 AS build

# Set working directory inside the container for the build process
WORKDIR /app

# Copy package.json and package-lock.json to install dependencies first
COPY package.json package-lock.json ./

# Install dependencies
RUN npm install

# Copy the entire project into the container
COPY . .

# Build the Angular application
RUN npm run build --prod

# Runtime Stage
FROM nginx:alpine

# Set working directory inside the container
WORKDIR /usr/share/nginx/html

# Copy the built Angular application from the build stage
COPY --from=build app/dist/****/browser /usr/share/nginx/html

# Expose the default HTTP port
EXPOSE 80

# Start Nginx server
CMD ["nginx", "-g", "daemon off;"]
